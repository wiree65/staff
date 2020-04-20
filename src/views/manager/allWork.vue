<template>
  <div >
    <h1 style="padding:12px">ACCESS HISTORY</h1>
    <Nav/>
    <v-data-table dense :headers="headers" :items="information" item-key="name" class="elevation-1"></v-data-table>
  </div>
</template>
<script>
import axios from "@/axios/axios";
import Nav from "../../components/NavForM";
export default {
    components: {
      Nav},
  async mounted() {
    const response = await axios.get("/api/Staffs");
    console.log(response.data);
    this.data = response.data;
    // for(let i=0;i<this.data.length;i++){
        // const temp
    // }
    this.information=this.data
  },

  data: () => ({
    data: null,
    information: [
      
    ],
    headers: [
      {
        text: "firstname",
        align: "lastname",
        sortable: false,
        value: "name"
      },
      { text: "firstname", value: "name" },
      { text: "lastname", value: "lastname" },
      { text: "id", value: "id" },
      { text: "branch", value: "branch" },
      { text: "salary", value: "salary" }
    ]
  })
};
</script>