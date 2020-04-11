<template>
  <div>
    <Nav />
    <!-- //////////////request form/////////////// -->
    <br />
    <h1 class="text-center">Request Form</h1>
    <br />
    <!--<v-alert type="error">
      You must filled in the blank before press “Submit”.
    </v-alert>-->
    <div>
      <v-card class="pa-md-4 mx-lg-auto" color="white" width="50%">
        <v-card-text>
          <v-form v-model="valid">
            <v-container>
              <v-row>
                <v-col cols="2"></v-col>
                <v-col md="3">
                  <v-text-field
                    v-model="firstname"
                    :rules="nameRules"
                    :counter="10"
                    label="First name"
                    required
                  ></v-text-field>
                </v-col>
<v-col cols="1">
</v-col>
                <v-col md="3">
                  <v-text-field
                    v-model="lastname"
                    :rules="nameRules"
                    :counter="10"
                    label="Last name"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </v-card-text>
      </v-card>
    </div>
  </div>
</template>
<script>
import Nav from "../components/Nav";
export default {
  components: {
    Nav
  },
   data: () => ({
      valid: false,
      firstname: '',
      lastname: '',
      nameRules: [
        v => !!v || 'Name is required',
        v => v.length <= 10 || 'Name must be less than 10 characters',
      ],
      email: '',
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+/.test(v) || 'E-mail must be valid',
      ],
    })
};
</script>
<style>
</style>