<template>
  <div>
    <template>
      <v-data-table :headers="headers" :items="information" class="elevation-1">
        <template v-slot:top>
          <v-dialog v-model="dialog" max-width="500px">
            <v-card>
              <v-card-title>
                <span class="headline">{{ formTitle }}</span>
              </v-card-title>

              <!-- /comment -->
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="8">
                      <v-textarea name="input-7-1" label="Comment" v-model="comment"></v-textarea>
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-select :items="states1" label="Confirm" v-model="status"></v-select>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>
              <!-- /comment -->
              <v-card-actions>
                <v-spacer></v-spacer>

                <v-btn color="blue darken-1" text @click=" confirm()">Save</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </template>
        <template v-slot:item.actions="{ item }">
          <v-icon small class="mr-6" @click="editItem(item)">mdi-pencil</v-icon>
        </template>
        <template v-slot:no-data></template>
      </v-data-table>
    </template>
  </div>
</template>

<script>
import axios from "@/axios/axios";

export default {
  components: {},

  async mounted() {
    const response = await axios.get("/api/WaitingReceivedRequestFormServlet", {
      withCredentials: true
    });
    console.log(response.data);
    this.data = response.data;
    this.information = this.data;
  },
  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "New Item" : "Confirmation";
    }
  },
  data: () => ({
    dialog: false,
    data: null,
    information: [],
    form_no: "",
    comment: "",

    headers: [
      {
        text: "form_no",
        align: "start",
        sortable: false,
        value: "form_no"
      },
      { text: "Staff ID", value: "staff_id" },
      { text: "Name", value: "name" },
      { text: "Topic", value: "topic" },
      { text: "Send Date", value: "send_date" },
      { text: "Description", value: "description" },
      { text: "Confirm", value: "actions", sortable: false }
    ],

    status: "",
    states1: ["Approved","Disapproved"]
  }),

  created() {
    this.initialize();
  },

  methods: {
    initialize() {
      this.desserts = [];
    },

    editItem(item) {
      this.editedIndex = this.desserts.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },

    close() {
      this.dialog = false;
      setTimeout(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      }, 300);
    },

    confirm() {
      axios
        .post("/api/ApproveRequestServlet", null, {
          withCredentials: true,
          params: {
            form_no: this.form_no,
            comment: this.comment,
            status: this.status
            
          }
        })
        location.reload();
        // .then(() => this.$router.push({ name: "manager" }))
        // .catch(console.log);
    }
  }
};
</script>