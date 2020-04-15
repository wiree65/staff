<template>
  <div>
    <Nav />
    <!-- //////////////request form/////////////// -->
    <br />
    <h1 class="text-center">Registration</h1>
    <br />
    <div>
      <v-card class="pa-md-4 mx-lg-auto" color="white" width="50%">
        <v-card-text>
          <v-form v-model="valid">
            <v-container>
              <br />
              <!-- Row 1: Header Part No.1 -->
              <v-row>
                <h2>Part 1: Personal Info</h2>
              </v-row>
              <br />
              <br />
              <!-- Row 2: Firstname & Lastname -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col cols="4">
                  <v-text-field
                    v-model="name"
                    :rules="nameRules"
                    label="First name"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col cols="4">
                  <v-text-field
                    v-model="lastname"
                    :rules="lastnameRules"
                    label="Last name"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
              <!-- Row 3: Nickname & CitizenID -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="4">
                  <v-text-field
                    v-model="nickname"
                    :rules="nicknameRules"
                    label="Nickname"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col md="4">
                  <v-text-field
                    v-model="citizen_id"
                    :rules="citizenRules"
                    :counter="13"
                    label="Citizen ID"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
              <!-- Row 4: Birthdate & Sex -->
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
                      <v-text-field
                        v-model="date_of_birth"
                        label="Birthdate"
                        readonly
                        v-on="on"
                        required
                      ></v-text-field>
                    </template>
                    <v-date-picker v-model="date_of_birth" no-title scrollable>
                      <v-spacer></v-spacer>
                      <v-btn text color="primary" @click="menu = false">Cancel</v-btn>
                      <v-btn text color="primary" @click="$refs.menu.save(date)">OK</v-btn>
                    </v-date-picker>
                  </v-menu>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col md="4">
                  Sex
                  <v-radio-group v-model="sex" row>
                    <v-radio label="Male" value="Male"></v-radio>
                    <v-radio label="Female" value="Female"></v-radio>
                  </v-radio-group>
                </v-col>
              </v-row>
              <!-- Row 5: Email & Phone -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col cols="4">
                  <v-text-field
                    v-model="email"
                    :rules="emailRules"
                    label="E-mail"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col cols="4">
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
              <!-- Row 6: Address -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="10">
                  <v-text-field
                    label="Address"
                    :rules="rules"
                    hide-details="auto"
                    v-model="address"
                  ></v-text-field>
                </v-col>
              </v-row>
              <br />
              <br />
              <!-- Row 7: Header Part No.2 -->
              <v-row>
                <h2>Part 2: Office</h2>
              </v-row>
              <br />
              <br />
              <!-- Row 8: Username & Password -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="4">
                  <v-text-field
                    v-model="username"
                    :rules="rules1"
                    label="Username"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col md="4">
                  <v-text-field
                    v-model="password"
                    :rules="passwordRules"
                    :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                    :rules2="[rules2.min]"
                    :type="show1 ? 'text' : 'password'"
                    name="input-10-1"
                    label="Password"
                    hint="At least 8 characters"
                    counter
                    @click:append="show1 = !show1"
                  ></v-text-field>
                </v-col>
              </v-row>
              <!-- Row 9: Department & Brunch -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="4">
                  <v-select
                    v-model="department"

                    :items="states"
                    
                    menu-props="auto"
                    label="Select"
                    hide-details
                    single-line
                  ></v-select>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col md="4">
                  <v-text-field
                    v-model="branch"
                    :rules="branchRules"
                    :counter="5"
                    label="Branch"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
              <!-- Row 10: Salary & Date of Employed -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="4">
                  <v-text-field label="Salary" suffix="฿" v-model="salary"></v-text-field>
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
                      <v-text-field
                        v-model="date_of_employed"
                        label="Date of Employed"
                        readonly
                        v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker v-model="date_of_employed" no-title scrollable>
                      <v-spacer></v-spacer>
                      <v-btn text color="primary" @click="menu2 = false">Cancel</v-btn>
                      <v-btn text color="primary" @click="$refs.menu2.save(date)">OK</v-btn>
                    </v-date-picker>
                  </v-menu>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </v-card-text>
      </v-card>
    </div>
    <br />
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
      <router-link to="/">
        <v-col cols="1">
          <div class="my-2">
            <v-btn color="primary" @click="newStaff()">Submit</v-btn>
          </div>
        </v-col>
      </router-link>
    </v-row>
  </div>
</template>
<script>
import Nav from "../components/Nav";
import equipment from "@/axios/axios";
export default {
  components: {
    Nav
  },
  //Name Required

  data: () => ({
    sex: "",
    salary: "",
    valid: false,
    name: "",
    nameRules: [v => !!v || "Name is required"],
    //Lastname Required
    lastname: "",
    lastnameRules: [v => !!v || "Lastname is required"],
    //Nickname Required
    nickname: "",
    nicknameRules: [v => !!v || "Nickname is required"],
    //Citizen ID Required
    citizen_id: "",
    citizenRules: [
      v => !!v || "Citizen ID is required",
      v => v.length <= 13 || "Citizen ID must be 13 digits"
    ],
    //Branch Required
    branch: "",
    branchRules: [
      v => !!v || "Branch is required",
      v => v.length <= 5 || "Branch must be less than 5 digits"
    ],
    //Phone No. Required
    tel: "",
    telRules: [
      v => !!v || "Phone No. is required",
      v => v.length >= 10 || "Phone No. must be 10 digits"
    ],
    //Email Required
    email: "",
    emailRules: [
      v => !!v || "E-mail is required",
      v => /.+@.+/.test(v) || "E-mail must be valid"
    ],
    //Address Required
    rules: [value => !!value || "Address is required"],
    //Username Required
    username: "",
    rules1: [
      value => !!value || "Username is required",
      value => value.length >= 5 || "Username must be at least 5 characters"
    ],
    //Password Required
    show1: false,
    password: "",
    passwordRules: [
      v => !!v || "Password is required",
      v => v.length >= 8 || "Password must be at least 8 characters"
    ],
    rules2: {
      min: v => v.length >= 8 || "Min 8 characters"
    },
    //Department Drop-down
    department: "",
    items: [
      { text: "State 1", value: 1 },
      { text: "State 2", value: '2' },
      { text: "State 3", value: '3' },
      { text: "State 4", value: '4' },
      { text: "State 5", value: '5' },
      { text: "State 6", value: '6' },
      { text: "State 7", value: '7' },
      { text: "State 8", value: '8' },
      { text: "State 9", value: '9' },
      { text: "State 10", value: '10' },
      { text: "State 11", value: '11' },
      { text: "State 12", value: '12' },
      { text: "State 13", value: '13' },
      { text: "State 14", value: '14' },
      { text: "State 15", value: '15' },
      { text: "State 16", value: '16' },
      { text: "State 17", value: '17' },
      { text: "State 18", value: '18' },
      { text: "State 19", value: '19' }
    ],
    states: [
      "MSME",
      "Rural & Agri Business",
      "Security",
      "Information Technology",
      "Treasury",
      "Wealth Management & Third Party Products",
      "Corporate Communications",
      "Support Services & Branch Expansion",
      "Human Resources",
      "Large Corporate & Loan Syndication",
      "Financial Inclusion",
      "Law Department",
      "Credit Recovery",
      "Risk Management",
      "Central Audit & Inspection",
      "Credit Monitoring and Restructuring",
      "Digital Banking",
      "Govt. Business Dept",
      "Branch Managers"
    ]
  }),
  //From-To Date of absent
  date: new Date().toISOString().substr(0, 10),
  menu: false,
  menu2: false,

  methods: {
    newStaff() {
      equipment
        .post("/api/RegisterServlet", null, {
          params: {
            username: this.username,
            password: this.password,
            salary: this.salary,
            nickname: this.nickname,
            name: this.name,
            lastname: this.lastname,
            date_of_birth: this.date_of_birth,
            tel: this.tel,
            email: this.email,
            citizen_id: this.citizen_id,
            sex: this.sex,
            address: this.address,
            date_of_employed: this.date_of_employed,
            branch: this.branch
            // department:this.department
          }
        })
        .then(() => this.$router.push({ name: "staff" }))
        .catch(console.log);
    }
  }
};
</script>
<style>
h2 {
  color: black;
}
</style>