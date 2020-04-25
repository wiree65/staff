<template>
  <div>
    <Nav />
    <v-container style="padding: 0%;" >
      <v-container style="padding: 0%;">
        <v-row>
          <v-col xs="2" md="2">
          </v-col>
          <v-col>
            <v-tabs v-model="tabs">
              <v-tab>Request</v-tab>
              <v-tab>Not Confirmed</v-tab>
              <v-tab>Confirmed</v-tab>
            </v-tabs>
          </v-col>
        </v-row>
      </v-container>
      <v-tabs-items v-model="tabs">
        <v-tab-item>
          <v-card flat>
            <v-card-text>
           <approve/>
              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>
        <v-tab-item>
          <v-card flat>
            <v-card-text>
           
              <unconfirmed />
              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>

        <v-tab-item>
          <v-card flat>
            <v-card-text>
           
              <confirmed />
              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>
      </v-tabs-items>


    </v-container>
  </div>

</template>

<script>
  import Nav from "../../../components/NavForM.vue";
  import unconfirmed from "./unconfirmed.vue"
  import confirmed from "./cofirmed.vue"
  import approve from "./approve.vue"
  export default {
    components: {
      Nav,approve,unconfirmed,confirmed
  
    },
    data() {
      return {
        tabs: null,
    
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