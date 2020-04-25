<template>
  <div>

    <!-- //////////////request form/////////////// -->
  
    
    <div>
      <v-card class="pa-md-4 mx-lg-auto" color="white" width="70%">
        <v-card-text>
          <v-form v-model="valid">
            <v-container>
            
               
              <v-row>
                <h2>Part 2: Information</h2>
              </v-row>
              <br />
              <br />
              <!-- Row 4: Type of topic -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="6">
                  <v-text-field
                    v-model="topic"
                    :rules="topicRules"
                    label="Topic"
                    clearable
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
              <!-- Row 5: Description -->
              <v-row>
                <v-col cols="1"></v-col>
                <v-col md="10">
                  <v-textarea name="input-7-1" label="Description" v-model="comment"></v-textarea>
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
                      <v-text-field v-model="to_date" label="From" readonly v-on="on" required></v-text-field>
                    </template>
                    <v-date-picker v-model="to_date" no-title scrollable>
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
              
              <br />
              <br />
              <hr />
              <br />
              <br />
              <v-row>
                <v-col cols="3">
                <h2>Part 3: Send to</h2>
                 </v-col>
                  <v-col>
                <h4>Which department do you want to send</h4>
                 </v-col>
              </v-row>
              <br />
              <br />
              <v-row>
                <v-col cols="1"></v-col>
                <v-col cols="4">
                  <v-select
                    v-model="sendDepartment"
                    :items="depart"
                    :rules="[v => !!v || 'Choose the department you want to sending']"
                    label="Department"
                    required
                  ></v-select>
                </v-col>
                <v-col cols="2"></v-col>
                <v-col cols="4"></v-col>
              </v-row>
            </v-container>
          </v-form>
        </v-card-text>
      </v-card>
    </div>
    <!-- Annotations -->
    <v-row>
      <v-col cols="3"></v-col>
      <v-col cols="9">
        <b>Annotations:</b>
        <br />
        <br />- You must request form in 3-5 days notice.
        <br />- This request form might send to your manager, head of brunch and head of department automatically.
        <br />- After you turn in the form, you must wait comment from commitee and return back in the system.
        <br />- If your request don’t return back after 2 days. Please click
        <b>“Contact Admin”</b> button in the system and tell some message again.
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
            <v-btn color="primary" @click="newStaff()">Submit</v-btn>
          </div>
        </v-col>
      </router-link>
    </v-row>
  </div>
</template>
<script>

import axios from "@/axios/axios";
export default {
  
  //Name & Lastname Required
  data: () => ({
    valid: false,
    firstname: "",
    lastname: "",
    nameRules: [
      v => !!v || "Name is required",
      v => v.length <= 20 || "Name must be less than 20 characters"
    ],
    //Brunch Required
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
    //Brunch Required
    sendBranch: "",
    Sbranch: [
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
      v => v.length <= 10 || "Phone No. must be less than 10 digits"
    ],
    //Email Required
    email: "",
    emailRules: [
      v => !!v || "E-mail is required",
      v => /.+@.+/.test(v) || "E-mail must be valid"
    ],
    //Department
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
    ],
    //Send Department
    sendDepartment: "",
    depart: [
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
    ],
    //Topic
    topic: "",
    topicRules: [v => !!v || "Topic is required"]
  }),
  methods: {
    newStaff() {
      axios
        .post("/api/requestServlet", null, {
          withCredentials: true,
          params: {
            topic: this.topic,
            description: this.description,
            from_date: this.from_date,
            to_date: this.to_date,
            send_to:this.send_to
          

          
          }
        })
        .then(() => this.$router.push({ name: "staff" }))
        .catch(console.log);
    }
  }
};
</script>
<style>
</style>