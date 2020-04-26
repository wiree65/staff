<template>
  <div>
    <!-- ////////////////////////////////////name +last name///////////////////////////////// -->
    <v-container>
      <v-row style="padding: 0%;">
        <v-col xs="2" md="2" style="padding: 0%;"></v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">Name</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].name}}</h3>
          </v-card>
        </v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">Last name</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].lastname}}</h3>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <!-- ////////////////////////////////////staff ID +Nickname///////////////////////////////// -->
    <v-container>
      <v-row>
        <v-col xs="2" md="2" style="padding: 0%;"></v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">Staff ID</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].id}}</h3>
          </v-card>
        </v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">Nickname</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].nickname}}</h3>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <!-- ////////////////////////////////////GENDER  + AGE///////////////////////////////// -->
    <v-container>
      <v-row>
        <v-col xs="2" md="2" style="padding: 0%;"></v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">Gender</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].sex}}</h3>
          </v-card>
        </v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">Birth date</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].date_of_birth}}</h3>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <!-- ////////////////////////////////////Number ID  + Birth date///////////////////////////////// -->
    <v-container>
      <v-row>
        <v-col xs="2" md="2" style="padding: 0%;"></v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">citizen ID</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].citizen_id}}</h3>
          </v-card>
        </v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">Employed date</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].date_of_employed}}</h3>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <!-- ////////////////////////////////////Department  + Branch///////////////////////////////// -->
    <v-container>
      <v-row>
        <v-col xs="2" md="2" style="padding: 0%;"></v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">Department</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].department}}</h3>
          </v-card>
        </v-col>
        <v-col xs="1" md="1" style="padding: 0%;">
          <v-card style="background-color: #64B5F6;" class="vcard">
            <h3 class="h3">Branch</h3>
          </v-card>
        </v-col>
        <v-col xs="3" md="3" style="padding: 0%;">
          <v-card style="height: 3em;" class="vcardb">
            <h3>{{data[0].branch}}</h3>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>
<style scoped>
.h3 {
  color: white;

  text-align: center;
}

.vcard {
  background-color: white;
  height: 3em;
  display: flex;
  align-items: center;
  justify-content: center;
}
.vcardb {
  height: 3em;
  display: flex;
  align-items: center;
  padding-left: 20px;
}
</style>
<script>
import auth from "../../../auth";
import equipment from "@/axios/axios";
export default {
  data() {
    return {
      data: null
    };
  },
   created(){
    let login = auth.getLogin();
    console.log(login);
    if(!login.auth){
      this.$router.push('/');
      alert("please login")
    }
  },
  async mounted() {
    const response = await equipment.get("/api/PersonalInfoServlet", {
      withCredentials: true
    });
    // console.log(response.data);
    this.data = response.data;
  }
};
</script>