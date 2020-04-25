<template>
  <div>
    <div>
      <v-card class="pa-md-4 mx-lg-auto" color="white">
        <v-card-text>
          <v-form v-model="valid">
            <v-container>
                <v-row>
                <v-col cols="2"></v-col>
                <v-col cols="4"  style="justify-content: bott;align-items: flex-end;display: flex;">
                  <v-text-field
                    v-model="event_name"
                    :rules="nameRules"
                    label="Event Name"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="1"></v-col>
                <v-col cols="4">
                  <v-textarea name="input-7-1" label="detail" v-model="detail"></v-textarea>
                </v-col>
              </v-row>
              
              <v-row>
                <v-col cols="2"></v-col>
                <v-col md="4">
                  <v-menu
                    ref="menu"
                    v-model="menu"
                    :close-on-content-click="false"
                    :return-value.sync="date"
                    transition="scale-transition"
                    offset-y
                    min-width="290px"
                  >
                    <template v-slot:activator="{ on }">
                      <v-text-field
                        v-model="start_date"
                        label="Start Date"
                        readonly
                        v-on="on"
                        required
                      ></v-text-field>
                    </template>
                    <v-date-picker v-model="start_date" no-title scrollable>
                      <v-spacer></v-spacer>
                      <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
                      <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
                    </v-date-picker>
                  </v-menu>
                </v-col>
                <v-col cols="1"></v-col>

                <!-- --------------------------------- -->
                <v-col md="4">
                    <v-menu
                      ref="menu2"
                      v-model="menu2"
                      :close-on-content-click="false"
                      :return-value.sync="date"
                      transition="scale-transition"
                      offset-y
                      min-width="290px"
                    >
                      <template v-slot:activator="{ on }">
                        <v-text-field
                          v-model="end_date"
                          label="End Date"
                          readonly
                          v-on="on"
                        ></v-text-field>
                      </template>
                      <v-date-picker v-model="end_date" no-title scrollable>
                        <v-spacer></v-spacer>
                        <v-btn text color="primary" @click="menu2 = false">Cancel</v-btn>
                        <v-btn text color="primary" @click="$refs.menu2.save(date)">OK</v-btn>
                      </v-date-picker>
                    </v-menu>
                  </v-col>
              </v-row>
              

              
            </v-container>
          </v-form>
        </v-card-text>
      </v-card>
    </div>
    <br />
    <!-- Buttons -->
    <v-row>
      <v-col cols="5"></v-col>
      <router-link to="/request">
        <v-col cols="1">
          <div class="my-2">
            <v-btn color="error">Cancel</v-btn>&nbsp;&nbsp;
          </div>
        </v-col>
      </router-link>
      <router-link to="/">
        <v-col cols="1">
          <div class="my-2">
            <v-btn color="primary" @click="createEvent()">Submit</v-btn>
          </div>
        </v-col>
      </router-link>
    </v-row>
  </div>
</template>
<script>
import equipment from "@/axios/axios";
export default {
  components: {},
  //Name Required

  data: () => ({
    event_name:'',
    detail:'',
    start_date:'',
    end_date:''

  }),
  //From-To Date of absent
 

  methods: {
    createEvent() {
      equipment
        .post("/api/InsertCalendar", null, {
          params: {
           event_name:this.event_name,detail:this.detail,start_date:this.start_date,end_date:this.end_date
          }
        })
        .then(() => this.$router.push({ name: "manager" }))
        .catch(console.log);
    }
  }
};
</script>
<style>
h2 {
  color: black;
}
</style>