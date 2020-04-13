<template>
  <div>
    <input v-model="username" />ha
    <input v-model="password" type="password" />ha
    <input type="submit" @click="newStaff()" />
  </div>
</template>
<script>
import equipment from "@/axios/axios";
export default {
  data() {
    return {
      username: "",
      password: ""
    };
  },
  methods: {
    newStaff() {
      equipment
        .post("/api/RegisterServlet", null, {
          params: { username: this.username, password: this.password }
        })
        .then(() => this.$router.push({ name: "staff" }))
        .catch(console.log);
    }
  }
};
</script>