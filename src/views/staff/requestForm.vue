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
              <v-tab>Waiting Request</v-tab>
              <v-tab>Approved Request</v-tab>
              <v-tab>Disapproved Request</v-tab>
              <v-tab>Request</v-tab>
            </v-tabs>
          </v-col>
        </v-row>
      </v-container>
      <v-tabs-items v-model="tabs">
        <v-tab-item>
          <v-card flat>
            <v-card-text>
           <getRquest/>
              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>
        
        <v-tab-item>
          <v-card flat>
            <v-card-text>
           <approved/>
              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>

        <v-tab-item>
          <v-card flat>
            <v-card-text>
           <disapproved/>
              <!-- ------------------info--------------------- -->
            </v-card-text>
          </v-card>
        </v-tab-item>


        <v-tab-item>
          <v-card flat>
            <v-card-text>
           
              <request />
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
  import request from "./getRQ/request.vue"
  import getRquest from "./getRQ/getRequest.vue"
  import approved from "./getRQ/approved.vue"
  import disapproved from "./getRQ/disapproved.vue"
  export default {
    components: {
      Nav,
      request,getRquest,approved,disapproved
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