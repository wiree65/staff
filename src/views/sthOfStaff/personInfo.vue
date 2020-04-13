<template>
    <div>
        <!-- ////////////////////////////////////name +last name///////////////////////////////// -->
        <v-container >

            <v-row style="padding: 0%;">
                <v-col xs="2" md="2" style="padding: 0%;">
                </v-col>
                <v-col xs="1" md="1" style="padding: 0%;">
                    <v-card style="background-color: #64B5F6;" class="vcard">
                        <h3 class="h3">Name</h3>
                    </v-card>
                </v-col>
                <v-col xs="3" md="3" style="padding: 0%;">
                    <v-card style="height: 3em;" class="vcardb">
                        <h3>{{data[0].name}}</h3>
                    </v-card>
                </v-col>
                <v-col xs="1" md="1" style="padding: 0%;">
                    <v-card  style="background-color: #64B5F6;" class="vcard">
                        <h3 class="h3">Last name</h3>
                    </v-card>
                </v-col>
                <v-col xs="3" md="3" style="padding: 0%;">
                    <v-card style="height: 3em;"  class="vcardb">
                        <h3 >{{data[0].lastname}}</h3>
                    </v-card>
                </v-col>



            </v-row>
        </v-container>
        <!-- ////////////////////////////////////staff ID +Nickname///////////////////////////////// -->
        <v-container>

            <v-row>
                <v-col xs="2" md="2" style="padding: 0%;">
                </v-col>
                <v-col xs="1" md="1" style="padding: 0%;">
                    <v-card style="background-color: #64B5F6;" class="vcard">
                        <h3 class="h3">Staff ID</h3>
                    </v-card>
                </v-col>
                <v-col xs="3" md="3" style="padding: 0%;">
                    <v-card style="height: 3em;" class="vcardb">
                        <h3>{{data[0].name}}</h3>
                    </v-card>
                </v-col>
                <v-col xs="1" md="1" style="padding: 0%;">
                    <v-card  style="background-color: #64B5F6;" class="vcard">
                        <h3 class="h3">Nickname</h3>
                    </v-card>
                </v-col>
                <v-col xs="3" md="3" style="padding: 0%;">
                    <v-card style="height: 3em;"  class="vcardb">
                        <h3 >{{data[0].lastname}}</h3>
                    </v-card>
                </v-col>



            </v-row>
        </v-container>
        <!-- ////////////////////////////////////GENDER  + AGE///////////////////////////////// -->
        <v-container>

            <v-row>
                <v-col xs="2" md="2" style="padding: 0%;">
                </v-col>
                <v-col xs="1" md="1" style="padding: 0%;">
                    <v-card style="background-color: #64B5F6;" class="vcard">
                        <h3 class="h3">Gender</h3>
                    </v-card>
                </v-col>
                <v-col xs="3" md="3" style="padding: 0%;">
                    <v-card style="height: 3em;" class="vcardb">
                        <h3>{{data[0].name}}</h3>
                    </v-card>
                </v-col>
                <v-col xs="1" md="1" style="padding: 0%;">
                    <v-card  style="background-color: #64B5F6;" class="vcard">
                        <h3 class="h3">Age</h3>
                    </v-card>
                </v-col>
                <v-col xs="3" md="3" style="padding: 0%;">
                    <v-card style="height: 3em;"  class="vcardb">
                        <h3 >{{data[0].lastname}}</h3>
                    </v-card>
                </v-col>



            </v-row>
        </v-container>
        <!-- ////////////////////////////////////Number ID  + Birth date///////////////////////////////// -->
        <v-container>

            <v-row>
                <v-col xs="2" md="2" style="padding: 0%;">
                </v-col>
                <v-col xs="1" md="1" style="padding: 0%;">
                    <v-card style="background-color: #64B5F6;" class="vcard">
                        <h3 class="h3">Number ID</h3>
                    </v-card>
                </v-col>
                <v-col xs="3" md="3" style="padding: 0%;"> 
                    <v-card style="height: 3em;" class="vcardb">
                        <h3>{{data[0].name}}</h3>
                    </v-card>
                </v-col>
                <v-col xs="1" md="1" style="padding: 0%;">
                    <v-card  style="background-color: #64B5F6;" class="vcard">
                        <h3 class="h3">Birth date</h3>
                    </v-card>
                </v-col>
                <v-col xs="3" md="3" style="padding: 0%;">
                    <v-card style="height: 3em;"  class="vcardb">
                        <h3 >{{data[0].lastname}}</h3>
                    </v-card>
                </v-col>



            </v-row>
        </v-container>
    </div>
</template>
<style scoped>
   
    .h3 {
        color: white;
 
        text-align: center;
    }

    .vcard {
        background-color: #64B5F6;
        height: 3em;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .vcardb {
        background-color: #64B5F6;
        height: 3em;
        display: flex;
        align-items: center;
        padding-left: 20px;
    }
</style>
<script>
    import equipment from "@/axios/axios";
    export default {
        data() {
            return {
                data: null
            };
        },
        async mounted() {
            const response = await equipment.get("/api/Staffs");
            console.log(response.data);
            this.data = response.data;
        }
    };
</script>