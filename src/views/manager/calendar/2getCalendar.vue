<template>
  <div>
    <Nav />
    <v-container style="padding: 0%;">
      <v-container style="padding: 0%;">
        <v-row>
          <v-col xs="2" md="2"></v-col>
          <v-col>
            <v-tabs v-model="tabs">
              <v-tab>Calendar</v-tab>
              <v-tab>Create Event</v-tab>
            </v-tabs>
          </v-col>
        </v-row>
      </v-container>
      <v-tabs-items v-model="tabs">
        <v-tab-item>
          <v-card flat>
            <v-card-text>
                 <calendar />
             
              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>

        <v-tab-item>
          <v-card flat>
            <v-card-text>
              <createCalendar />
              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
    </v-container>
  </div>
</template>

<script>
import Nav from "../../../components/Nav";
import calendar from "./calendar";
import createCalendar from "./createCalendar";
import auth from "../../../auth";

export default {
  components: {
    Nav,
    calendar,
    createCalendar
  },
  created(){
    let login = auth.getLogin();
    console.log(login);
    if(!login.auth){
      this.$router.push('/');
      alert("please login")
    }
  },
  data() {
    return {
      tabs: null
    };
  }
};
</script>
<style scoped>
.h4 {
  text-align: center;
  justify-content: center;
}

.con3 {
  border-radius: 1em;
  box-shadow: 5px 0px 10px #888888;
  border: 2px #9d9d9d;
}

.con4 {
  border-radius: 1em;
  box-shadow: 5px 0px 10px #888888;
  border: 2px #9d9d9d;
  background-color: #e3f2fd;
}

.col1 {
  justify-content: center;
  display: flex;
}
</style>