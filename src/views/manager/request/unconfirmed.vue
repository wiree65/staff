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
  async mounted() {
    const response = await axios.get("/api/DispprovedReceivedRequestFormServlet",{
      withCredentials: true
    });
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
      { text: "Firstname", value: "name" },
      { text: "Lastname", value: "lastname" },
      { text: "Topic", value: "topic" },
      { text: "Description", value: "description" },
       { text: "Comment", value: "comment" },
      { text: "Status", value: "status" }
    ]
  })
};
</script>