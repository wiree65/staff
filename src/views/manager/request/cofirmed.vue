<template>
  <div >
 
  
    <v-data-table dense :headers="headers" :items="information" item-key="name" class="elevation-1"></v-data-table>
  </div>
</template>
<script>
import axios from "@/axios/axios";

export default {
  
  async mounted() {
    const response = await axios.get("/api/Staffs");
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
        value: "id"
      },
      { text: "firstname", value: "name" },
      { text: "lastname", value: "lastname" },
      { text: "id", value: "id" },
      { text: "date of employed", value: "date_of_employed" },
      { text: "salary", value: "salary" }
    ]
  })
};
</script>