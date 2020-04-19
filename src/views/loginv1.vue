<template>
  <div class="bg py-12">
    <div class="box white pa-12">
      <div class="my-4">
        <div class="display-2 font-weight-bold">Welcome to, CSB</div>
        <div class="display-1 font-weight-light">Please Login</div>
      </div>
      <form class="my-4">
        <v-text-field
          v-model="name"
          :error-messages="nameErrors"
          :counter="10"
          label="Name"
          required
          @input="$v.name.$touch()"
          @blur="$v.name.$touch()"
          @keypress.enter="login"
        ></v-text-field>
        <v-text-field
          v-model="password"
          :error-messages="passwordErrors"
          label="Password"
          required
          type="password"
          @input="$v.password.$touch()"
          @blur="$v.password.$touch()"
          @keypress.enter="login"
        ></v-text-field>

        <v-btn class="my-4 darken-2 mx-4 white--text" color="blue" outlined @click="login">Login</v-btn>
      </form>
    </div>
  </div>
</template>
<script>
import { validationMixin } from "vuelidate";
import { required, maxLength } from "vuelidate/lib/validators";
import axios from "@/axios/axios";

// import Cookie from "js-cookie";
import auth from "../auth";
export default {
  mixins: [validationMixin],

  validations: {
    name: { required, maxLength: maxLength(10) },
    password: { required }
  },

  data: () => ({
    name: "",
    password: "",
    showAlert: false,
    nameE: false,
    passwordE: false
  }),

  methods: {
    login() {
      this.$v.$touch();
      if (!this.$v.name.$invalid && !this.$v.password.$invalid) {
        let formData = new FormData();
        formData.append("username", this.name);
        formData.append("password", this.password);

        axios
          .post("api/SigninServlet", formData, {
            withCredentials: true
          })
          .then((respond) => {
            auth.setLogin(true);
            if(respond.data.role=="manager"){
            this.$router.push("/homepage");}
            else{
              this.$router.push("/allWork");
            }
          });
      }
    }
  }
};
</script>
          
   
<style scoped>
.bg {
  width: 100vw;
  min-height: 100vh;
  background: rgba(0, 0, 0, 0.1);
  display: flex;
  justify-content: center;
  align-items: center;
}
.bg .box {
  text-align: center;
  border-radius: 50px;
  min-width: 500px;
  width: 800px;
  justify-content: center;
  align-items: center;
}

.alert {
  position: absolute;
  bottom: 95px;
  left: 50%;
  transform: translateX(-50%);
}
</style>
