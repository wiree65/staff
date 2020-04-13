<template>
  <div>
    <Nav />
    <!-- //////////////request form/////////////// -->
    <br />
    <h1 class="text-center">Request Form</h1>
    <br />
    <div>
      <v-card class="pa-md-4 mx-lg-auto" color="white" width="50%">
        <v-card-text>
          <v-form v-model="valid">
            <v-container>
              <!-- Row 1: Firstname & Lastname -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col cols="4">
                  <v-text-field
                    v-model="firstname"
                    :rules="nameRules"
                    :counter="20"
                    label="First name"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
<<<<<<< Updated upstream
                <v-col cols="2"></v-col>
                <v-col cols="4">
=======
                <v-col cols="1"></v-col>
                <v-col md="3">
>>>>>>> Stashed changes
                  <v-text-field
                    v-model="lastname"
                    :rules="nameRules"
                    :counter="20"
                    label="Last name"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
              <!-- Row 2: Email & Phone No. -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="4">
                  <v-text-field
                    v-model="email"
                    :rules="emailRules"
                    label="E-mail"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col md="4">
                  <v-text-field
                    v-model="tel"
                    :rules="telRules"
                    :counter="10"
                    label="Phone"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
              <!-- Row 3: Department & Brunch -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="4">
                  <v-select
                    v-model="select"
                    :items="items"
                    :rules="[v => !!v || 'Input your department']"
                    label="Department"
                    required
                  ></v-select>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col md="4">
                  <v-text-field
                    v-model="brunch"
                    :rules="brunchRules"
                    :counter="5"
                    label="Brunch"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
              <!-- Row 4: Type of topic -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="6">
                  <v-select
                    v-model="select"
                    :items="topics"
                    :rules="[v => !!v || 'Input your type of topic']"
                    label="Type of topic"
                    required
                  ></v-select>
                </v-col>
              </v-row>
              <!-- Row 5: Description -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="10">
                  <v-textarea name="input-7-1" label="Description"></v-textarea>
                </v-col>
              </v-row>
              <!-- Row 6: From-to of absent -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="4">
                  <v-menu
                    ref="menu"
                    v-model="menu"
                    :close-on-content-click="false"
                    :return-value.sync="date"
                    transition="scale-transition"
                    offset-y
                    min-width="290px"
                  >
                    <template v-slot:activator="{ on }">
                      <v-text-field v-model="date" label="From" readonly v-on="on" required></v-text-field>
                    </template>
                    <v-date-picker v-model="date" no-title scrollable>
                      <v-spacer></v-spacer>
                      <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
                      <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
                    </v-date-picker>
                  </v-menu>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col md="4">
                  <v-menu
                    ref="menu2"
                    v-model="menu2"
                    :close-on-content-click="false"
                    :return-value.sync="date"
                    transition="scale-transition"
                    offset-y
                    min-width="290px"
                  >
                    <template v-slot:activator="{ on }">
                      <v-text-field v-model="date" label="To" readonly v-on="on"></v-text-field>
                    </template>
                    <v-date-picker v-model="date" no-title scrollable>
                      <v-spacer></v-spacer>
                      <v-btn text color="primary" @click="menu2 = false">Cancel</v-btn>
                      <v-btn text color="primary" @click="$refs.menu2.save(date)">OK</v-btn>
                    </v-date-picker>
                  </v-menu>
                </v-col>
              </v-row>
              <!-- Row 7: Import File -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col cols="10">
                  <v-file-input multiple label="Import File (if any)"></v-file-input>
                </v-col>
              </v-row>
              <!-- Row 8: CheckBox -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col cols="10">
                  <v-checkbox v-model="checkbox">
                    <template v-slot:label>
                      <div>
                        I agree this information is true. If the information above that is lie or/and not true,
                        <v-tooltip
                          bottom
                        >Lorem ipsum dolor sit amet consectetur adipisicing elit. Ullam expedita veritatis temporibus repellat fugiat, voluptatibus esse corporis rerum provident nam, quidem quod debitis delectus deleniti reiciendis quisquam labore impedit porro.</v-tooltip>I glad to receive the punishment and can ground for immediate termination.
                      </div>
                    </template>
                  </v-checkbox>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </v-card-text>
      </v-card>
    </div>
    <br />
    <!-- Annotations -->
    <v-row>
      <v-col cols="3"></v-col>
      <v-col cols="9">
        <b>Annotations:</b>
        <br />
        <br />- You must request form in 3-5 days notice.
        <br />- This request form might send to your manager, head of brunch and head of department automatically.
        <br />- After you turn in the form, you must wait comment from commitee and return back in the system.
        <br />- If your request don’t return back after 2 days. Please click <b>“Contact Admin”</b> button in the system and tell some message again.
        <br />
        <br />
      </v-col>
    </v-row>
    <!-- Buttons -->
    <v-row>
      <v-col cols="5"></v-col>
      <router-link to="/request">
        <v-col cols="1">
          <div class="my-2">
            <v-btn color="error">Cancel</v-btn>&nbsp;&nbsp;
          </div>
        </v-col>
      </router-link>
      <router-link to="/homepage">
        <v-col cols="1">
          <div class="my-2">
            <v-btn color="primary">Submit</v-btn>
          </div>
        </v-col>
      </router-link>
    </v-row>
  </div>
</template>
<script>
import Nav from "../components/Nav";
export default {
  components: {
    Nav
  },
<<<<<<< Updated upstream
  //Name & Lastname Required
=======
>>>>>>> Stashed changes
  data: () => ({
    valid: false,
    firstname: "",
    lastname: "",
    nameRules: [
      v => !!v || "Name is required",
<<<<<<< Updated upstream
      v => v.length <= 20 || "Name must be less than 20 characters"
    ],
    //Brunch Required
    brunch: "",
    brunchRules: [
      v => !!v || "Brunch is required",
      v => v.length <= 5 || "Brunch must be less than 5 digits"
    ],
    //Phone No. Required
    tel: "",
    telRules: [
      v => !!v || "Phone No. is required",
      v => v.length <= 10 || "Phone No. must be less than 10 digits"
    ],
    //Email Required
=======
      v => v.length <= 10 || "Name must be less than 10 characters"
    ],
>>>>>>> Stashed changes
    email: "",
    emailRules: [
      v => !!v || "E-mail is required",
      v => /.+@.+/.test(v) || "E-mail must be valid"
<<<<<<< Updated upstream
    ],
    //Department Drop-down
    select: null,
    items: ["Item 1", "Item 2", "Item 3", "Item 4"],
    //Type of Topic Drop-down
    topics: ["Item 1", "Item 2", "Item 3", "Item 4"],
    checkbox: false,
    lazy: false
  }),
  //From-To Date of absent
  date: new Date().toISOString().substr(0, 10),
  menu: false,
  menu2: false
=======
    ]
  })
>>>>>>> Stashed changes
};
</script>
<style>
</style>