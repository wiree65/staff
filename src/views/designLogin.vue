<template>
  <div>
    <!-- //////////////Login/////////////// -->
    <div class="box white pa-8"></div>
    <!--top box / color: blue-->
    <v-container style="position: relative;">
      <v-card
        class="mx-auto"
        max-width="688"
        min-height="250"
        style="border-top-right-radius: 2em;border-top-left-radius: 2em;"
      >
        <!--bottom box / color: white-->
        <v-card
          class="mx-auto"
          max-width="688"
          min-height="300"
          style="border-radius: 2em; background-color: #42A5F5;justify-items: center;align-items: center;display:flex;"
        >
          <v-row>
            <v-col cols="2"></v-col>
            <!-- Put Logo Here: CSB Banking -->
            <v-col cols="8" style="justify-items: center;align-items: center;display:grid;"> <br />
              <img src="../assets/logo-original.png" style="width: 200px;" /></v-col>
            <v-col cols="2"></v-col>
            <v-col cols="2"></v-col>
            <!-- MSG: Welcome -->
            <v-col cols="8" class="scopeBox">
              <p style="color: white;font-size: 25px;">Welcome to Staff Management System</p>
            </v-col>
            <v-col cols="2"></v-col>
            <v-col cols="2"></v-col>
            <!-- MSG: Login -->
            <v-col cols="8" class="scopeBox" style="padding:0%">
              <p style="color: white;font-size: 20px;">Please Login</p>
            </v-col>
            <v-col cols="2"></v-col>
          </v-row>
        </v-card>
        <v-row>
          <v-col cols="2"></v-col>
          <v-col cols="8" class="scopeBox2">
            <!-- Back-End Zone-->
            <v-text-field
              v-model="name"
              :rules="nameRules"
              :error-messages="nameErrors"
              :counter="10"
              label="Name"
              required
              @input="$v.name.$touch()"
              @blur="$v.name.$touch()"
              @keypress.enter="login"
              style="width: 90%;"
            ></v-text-field>
            <v-text-field
              v-model="password"
              :rules="pwRules"
              :error-messages="passwordErrors"
              label="Password"
              required
              type="password"
              @input="$v.password.$touch()"
              @blur="$v.password.$touch()"
              @keypress.enter="login"
              style="width: 90%;"
            ></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="8"></v-col>
          <!-- Button Login -->
          <v-col cols="2" class="scopeBox">
            <v-btn text color="primary" @click="login()">Login</v-btn>
          </v-col>
          <v-col cols="2"></v-col>
        </v-row>
        <v-row>
          <!-- Forgot Password -->
          <v-col cols="4" class="scopeBox">
            <v-btn text color="primary">
              <v-icon color="gray" style="width: 80%;">fas fa-key</v-icon>
              <p class="forgotPW">Forgot password</p>
            </v-btn>
          </v-col>
        </v-row>
        <v-card-actions style="padding:5px"></v-card-actions>
        <v-spacer></v-spacer>
        <v-expand-transition>
          <div v-show="show">
            <v-divider></v-divider>
          </div>
        </v-expand-transition>
      </v-card>
    </v-container>
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
    nameRules: [
      v => !!v || "Name is required",
      v => v.length <= 10 || "Name must be less than 10 characters"
    ],
    password: "",
    pwRules: [v => !!v || "Password is required"],
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
          .then(respond => {
            auth.setLogin(true);
            if (respond.data.role == "manager") {
              this.$router.push("/manager");
            } else if (respond.data.role == "staff") {
              this.$router.push("/homepage");
            } else if (
              respond.data.role != "manager" ||
              respond.data.role != "staff"
            ) {
              alert("Something Wrong");
            } 
          })
          .catch(() => {
            alert("Something Wrong");
          });
      }
    }
  }
};
</script>
<style scoped>
.scopeBox {
  justify-items: center;
  align-items: center;
  display: grid;
  padding-bottom: 0px;
}

.scopeBox2 {
  justify-items: center;
  align-items: center;
  display: grid;
}

.forgotPW {
  font-size: 11px;
  margin: 0px;
  padding: 12px;
}
</style>