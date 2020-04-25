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
    const response = await axios.get("/api/DisapproveGetRequestFormServlet",{  withCredentials: true});
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
        text: "Form No.",
        align: "lastname",
        sortable: false,
        value: "form_no"
      },
      { text: "Topic", value: "topic" },
      { text: "Description", value: "description" },
      { text: "Sent to", value: "send_to" },
       { text: "Status", value: "status" },
       
      
        { text: "Return Date", value: "return_date" },
      { text: "Comment", value: "comment" }
    ]
  })
};
</script>