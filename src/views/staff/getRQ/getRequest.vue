<template>
  <div >

 
    <v-data-table dense :headers="headers" :items="information" item-key="name" class="elevation-1"></v-data-table>
  </div>

</template>

<script>

import axios from "@/axios/axios";

export default {
    components: {
    },
//  created(){
//     let login = auth.getLogin();
//     console.log(login);
//     if(!login.auth){
//       this.$router.push('/');
//       alert("please login")
//     }
//   },
  async mounted() {
    const response = await axios.get("/api/GetMyRequestFormServlet",{  withCredentials: true});
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
        text: "id",
        align: "lastname",
        sortable: false,
        value: "staff_id"
      },
      { text: "firstname", value: "name" },
      { text: "lastname", value: "lastname" },
      { text: "topic", value: "topic" },
      { text: "description", value: "description" },
      { text: "status", value: "status" }
    ]
  })
};
</script>