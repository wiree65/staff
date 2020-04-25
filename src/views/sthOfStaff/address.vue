<template>
  <div>
    <!-- ////////////////////////////////////address///////////////////////////////// -->
    <v-container>
      <v-row>
        <v-col xs="2" md="2" class="col"></v-col>
        <v-col xs="2" md="2" class="col">
          <v-card style="background-color: #64B5F6;height: 5em;display: flex;justify-self: center;align-items: center;padding-left: 35px;" class="vcard">
            <h3 style="color: white;">First Address</h3>
          </v-card>
        </v-col>
        <v-col xs="6" md="6">
          <v-card style="height: 5em;display: flex;justify-self: center;align-items: center;padding-left: 12px;" class="vcardb">
            <h3 >{{data[0].address}}</h3>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>
<script>
import auth from "../../auth";

import equipment from "@/axios/axios";
export default {
  data() {
    return {
      data: null
    };
  },
  created() {
    let login = auth.getLogin();
    console.log(login);
    if (!login.auth) {
      this.$router.push("/");
      alert("please login");
    }
  },
  async mounted() {
    const response = await equipment.get("/api/PersonalInfoServlet", {
      withCredentials: true
    });
    console.log(response.data);
    this.data = response.data;
  }
};
</script>