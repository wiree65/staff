<template>
  <div>
    <Nav />

    <Carousel />
    <!-- /////////////////////////////////////////// --><br />
    <v-container class="con2">
      <v-row>
        <template>

          <v-col>
            <img src="../assets/Ellipse 7.png" style="margin-top:4%;margin-left:5%;width: 95%;">
          </v-col>
          <v-col>
            <center>
              <h1 style="font-size: 225%;margin-top: 18%;">CHAIR MAN</h1><br />

              <h4>Name: WIRAWAT</h4><br />
              <h4>Last name: JAIARREE</h4><br />
              <h4>Staff ID: 62130500225</h4>
            </center>
          </v-col>

        </template>
      </v-row>
    </v-container>


    <!-- //////////////////// -->
    <v-container class="con1">
      <v-row>
        <template>

          <v-col>
            <!-- <router-link to="/about"> -->
            <v-btn large color="#1976D2" style="width: 90%;height: 17%;margin-left: 5%;margin-top:-0.5%;">
              <p style="color: white;margin-top: 3%;font-size:150%;">Personal Info & Status</p>
            </v-btn>
          <!-- </router-link> -->
            <v-btn large color="#1E88E5" style="width: 90%;height: 17%;margin-left: 5%;margin-top: 5%;">
              <p style="color: white;margin-top: 3%;font-size: 150%;">Employee Information Menu</p>
            </v-btn>
            <router-link to="/about" style="text-decoration: none;">
            <v-btn large color="#42A5F5" style="width: 90%;height: 17%;margin-left: 5%;margin-top: 5%;">
              <p style="color: white;margin-top: 3%;font-size: 150%;">Employee History</p>
            </v-btn></router-link>
            <router-link to="/about" style="text-decoration: none;">
            <v-btn large color="#64B5F6" style="width: 90%;height: 17%;margin-left: 5%;margin-top: 5%;">
              <p style="color: white;margin-top: 3%;font-size: 150%;">Access History</p>
            </v-btn></router-link>
          </v-col>

        </template>
      </v-row>
    </v-container>
    <!-- //////////////////// -->
  </div>
</template>

<script>
  import Nav from "../components/Nav";
  import Carousel from "../components/Carousel";
  export default {
    components: {
      Nav,
      Carousel
    }
  };
</script>
<style>
  .con1 {
    position: absolute;
    border-radius: 1em;
    box-shadow: 5px 0px 10px #888888;
    border: 2px #9d9d9d;
    width: 45%;
    height: 50vh;
    margin-left: 52%;
  }
  .con2{
    position: absolute;border-radius:1em;box-shadow: 5px 0px 10px #888888;border: 2px #9d9d9d;
    width: 45%;height: 50vh;margin-left: 3%;
  }
</style>