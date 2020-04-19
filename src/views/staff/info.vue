<template>
  <div>
    <Nav />


    <v-container style="padding: 20px;padding-bottom: 0%;">
      <v-row>
        <v-col xs="2" md="2">

        </v-col>
        <v-col>
          <v-container class="con4">

            <h2 style="text-align: center;">Personal Info & Status</h2>

            <v-row style="align-items: center;display:flex;">

              <v-col xs="4" md="4" class="col1">
                <img src="../../assets/Ellipse 7.png" style="height: 150px;" />
              </v-col>

              <v-col xs="7" md="7" class="col1">
                <v-container class="con3" style="background-color: white;">
                  <v-row>

                    <v-col>

                      <h4 class="h4">Staff ID: 62130500225</h4>
                      <br />
                      <h4 class="h4">Name: Wirawat Jaiarree</h4>

                    </v-col>
                    <v-col>
                      <h4>Status: Working</h4>
                      <br />
                      <h4>Position: Staff</h4>
                    </v-col>

                  </v-row>
                </v-container>

              </v-col>




            </v-row>
          </v-container>

        </v-col>
        <v-col xs="2" md="2">

        </v-col>
      </v-row>
    </v-container>


    <!-- ----------------------------staff info---------------------------------------- -->
    <!-- 42A5F5 -->

    <v-container style="padding: 0%;" >


      <v-container style="padding: 0%;">

        <v-row>
          <v-col xs="2" md="2">

          </v-col>

          <v-col>
            <v-tabs v-model="tabs">
              <v-tab>Personal Info</v-tab>
              <v-tab>Address</v-tab>
            </v-tabs>
          </v-col>

        </v-row>

      </v-container>





      <v-tabs-items v-model="tabs">
        <v-tab-item>
          <v-card flat>
            <v-card-text>
              <personInfo />
              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>
        <v-tab-item>
          <v-card flat>
            <v-card-text>
              <test/>

              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>
      </v-tabs-items>

    </v-container>
  </div>
</template>

<script>
  import Nav from "../../components/Nav";
  import test from "../../views/sthOfStaff/address";
  import personInfo from "../../views/sthOfStaff/personInfo";
  export default {
    components: {
      Nav,
      personInfo,
      test
    },
    data() {
      return {
        tabs: null,
        text:
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
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