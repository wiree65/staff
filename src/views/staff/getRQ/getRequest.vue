<template>
  <div >

 
    <v-data-table dense :headers="headers" :items="information" item-key="name" class="elevation-1"></v-data-table>
  </div>

</template>

<script>

import axios from "@/axios/axios";
import auth from "../../../auth";
export default {
    components: {
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
    const response = await axios.get("/api/WaitingGetRequestFormServlet",{  withCredentials: true});
    console.log(response.data);
    this.data = response.data;
  
    this.information=this.data
  },

  data: () => ({
    data: null,
    information: [
      
    ],
    headers: [
      {
        text: "Sent to",
        align: "lastname",
        sortable: false,
        value: "send_to"
      },
      { text: "Topic", value: "topic" },
      { text: "Description", value: "description" },
      { text: "Status", value: "status" },
      { text: "Comment", value: "comment" }
    ]
  })
};
</script>