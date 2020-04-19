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
                  <v-select :items="states" label="Standard" v-model="department"></v-select>
                </v-col>
                <v-col cols="2"></v-col>
                 <v-col md="4">
                  <v-select :items="states1" label="Standard" v-model="branch"></v-select>
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
    states1: [
      "01 CS Bank KMUTT",
      "02 CS Bank KMITL",
      "03 CS Bank KMUTNB",
      "04 CS Bank Samut Prakarn",
      "05 CS Bank Nonthaburi",
      "06 CS Bank Pathum Thani",
      "07 CS Bank Phra Nakhon Si Ayutthaya",
      "08 CS Bank Ang Thong",
      "09 CS Bank Lop Buri",
      "10 CS Bank Sing Buri",
      "11 CS Bank Chai Nat",
      "12 CS Bank Saraburi",
      "13 CS Bank Chon Buri",
      "14 CS Bank Rayong",
      "15 CS Bank Chanthaburi",
      "16 CS Bank Trat",
      "17 CS Bank Chachoengsao",
      "18 CS Bank Prachin Buri",
      "19 CS Bank Nakhon Nayok",
      "20 CS Bank Sa kaeo",
      "21 CS Bank Nakhon Ratchasima",
      "22 CS Bank Buri Ram",
      "23 CS Bank Surin",
      "24 CS Bank Si Sa Ket",
      "25 CS Bank Ubon Ratchathani",
      "26 CS Bank Yasothon",
      "27 CS Bank Chaiyaphum",
      "28 CS Bank Amnat Charoen",
      "29 CS Bank Bueng Kan",
      "30 CS Bank Nong Bua Lam Phu",
      "31 CS Bank Khon Kaen",
      "32 CS Bank Udon Thani",
      "33 CS Bank Loei",
      "34 CS Bank Nong Khai",
      "35 CS Bank Maha Sarakham",
      "36 CS Bank Roi Et",
      "37 CS Bank Kalasin",
      "38 CS Bank Sakon Nakhon",
      "39 CS Bank Nakhon Phanom",
      "40 CS Bank Mukdahan",
      "41 CS Bank Chiang Mai",
      "42 CS Bank Lamphun",
      "43 CS Bank Lampang",
      "44 CS Bank Uttaradit",
      "45 CS Bank Phrae",
      "46 CS Bank Nan",
      "47 CS Bank Phayao",
      "48 CS Bank Chiang Rai",
      "49 CS Bank Mae Hong Son",
      "50 CS Bank Nakhon Sawan",
      "51 CS Bank Uthai Thani",
      "52 CS Bank Kamphaeng Phet",
      "53 CS Bank Tak",
      "54 CS Bank Sukhothai",
      "55 CS Bank Phitsanulok",
      "56 CS Bank Phichit",
      "57 CS Bank Phetchabun",
      "58 CS Bank Ratchaburi",
      "59 CS Bank Kanchanaburi",
      "60 CS Bank Suphan Buri",
      "61 CS Bank Nakhon Pathom",
      "62 CS Bank Samut Sakhon",
      "63 CS Bank Samut Songkhram",
      "64 CS Bank Phetchaburi",
      "65 CS Bank Prachuap Khiri Khan",
      "66 CS Bank Nakhon Si Thammarat",
      "67 CS Bank Krabi",
      "68 CS Bank Phang-nga",
      "69 CS Bank Phuket",
      "70 CS Bank Surat Thani",
      "71 CS Bank Ranong",
      "72 CS Bank Chumphon",
      "73 CS Bank Songkhla",
      "74 CS Bank Satun",
      "75 CS Bank Trang",
      "76 CS Bank Phatthalung",
      "77 CS Bank Pattani",
      "78 CS Bank Yala",
      "79 CS Bank Narathiwat"
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
    // Department Drop-down
    department: "",
    states: [
      "01 MSM1E",
      "02 Rural & Agri Business",
      "03 Security",
      "04 Information Technology",
      "05 Treasury",
      "06 Wealth Management & Third Party Products",
      "07 Corporate Communications",
      "08 Support Services & Branch Expansion",
      "09 Human Resources",
      "10 Large Corporate & Loan Syndication",
      "11 Financial Inclusion",
      "12Law Department",
      "13 Credit Recovery",
      "14 Risk Management",
      "15 Central Audit & Inspection",
      "16 Credit Monitoring and Restructuring",
      "17 Digital Banking",
      "18 Govt. Business Dept",
      "19 Branch Managers"
    ]

    // items: ["foo", "bar", "fizz", "buzz"],
    // department: ["1", "2", "3", "4"]
    // department:''
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
            branch: this.branch,
            department: this.department
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