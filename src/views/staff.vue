<template>
  <div>
    <Nav />

    <Carousel />
    <v-container>
      <v-row>
        <v-col cols="6" style="padding: 12px;">
          <v-container class="con1">
            <v-row style="height: 100%;">
              <v-col cols="6" class="center">
                <img src="../assets/Ellipse 7.png" style="width:250px;padding: 12px;" />
              </v-col>
              <v-col cols="6">
                <v-col cols="2"></v-col>
                <v-col>
                  <h1 class="center">STAFF</h1>
                </v-col>
                <v-col>
                  <h4 class="center">Name:{{this.info.name}}</h4>
                </v-col>
                <v-col>
                  <h4 class="center">Lastname: {{this.info.lastname}}</h4>
                </v-col>
                <v-col>
                  <h4 class="center">Staff ID: {{this.info.id}}</h4>
                </v-col>
              </v-col>
            </v-row>
          </v-container>
        </v-col>
        <!-- align-items: center; -->
        <!-- justify-content: center; -->
        <v-col cols="6">
          <v-container class="con1" style="display:grid;">
            <v-col>
              <router-link to="/info">
                <v-btn large color="#1976D2" style="width: 90%;;margin-left: 5%;">
                  <p style="color: white;font-size:150%;margin-bottom: 0px;">Personal Info & Status</p>
                </v-btn>
              </router-link>
            </v-col>
            <v-col>
              <v-btn large color="#1E88E5" style="width: 90%;;margin-left: 5%;">
                <p style="color: white;font-size: 150%;margin-bottom: 0px;">Approve Cheque</p>
              </v-btn>
            </v-col>
            <v-col>
              <router-link to="/request" style="text-decoration: none;">
                <v-btn large color="#42A5F5" style="width: 90%;margin-left: 5%;">
                  <p style="color: white;font-size: 150%;margin-bottom: 0px;">Request Form</p>
                </v-btn>
              </router-link>
            </v-col>
            <v-col>
              <router-link to="/about" style="text-decoration: none;">
                <v-btn large color="#64B5F6" style="width: 90%;margin-left: 5%;">
                  <p style="color: white;font-size: 150%;margin-bottom: 0px;">Calendar</p>
                </v-btn>
              </router-link>
            </v-col>
          </v-container>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import auth from "../auth";
import Nav from "../components/Nav";
import Carousel from "../components/Carousel";
import axios from "@/axios/axios";
export default {
  components: {
    Nav,
    Carousel
  },
  data() {
    return { info: null };
  },
  created(){
    let login = auth.getLogin();
    console.log(login);
    if(!login.auth){
      
      this.$router.push('/');
      alert("please login")
    }
  },
  mounted() {
    console.log(this.$auth);    
    axios
          .post("api/GetStaffServlet",null, {
            withCredentials: true
          })
          .then((response) => {
            this.info =response.data;
          });
  }
};
</script>
<style scoped>
.col1 {
  padding: 12px;
}

.center {
  display: flex;
  align-items: center;
  justify-content: center;
}

.con1 {
  border-radius: 1em;
  box-shadow: 5px 0px 10px #888888;
  border: 2px #9d9d9d;
  height: 350px;
}

.con2 {
  position: absolute;
  border-radius: 1em;
  box-shadow: 5px 0px 10px #888888;
  border: 2px #9d9d9d;
  width: 45%;
  height: 50vh;
  margin-left: 3%;
}
</style>