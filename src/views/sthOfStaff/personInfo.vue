<template>
    <div>
        <!-- ////////////////////////////////////name +last name///////////////////////////////// -->
        <v-container class="grey lighten-5" style="margin-left: 45%;padding-top: 0em;padding-bottom: 0em;">
            <v-row class="mb-6" no-gutters>
                <v-col>
                    <v-card style="width: 100%;background-color: #64B5F6;width: 10em;height: 3em;">
                        <h3 style="color: white;padding: 7%; text-align: center;">Name</h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 17em;height: 3em;">
                        <h3 style="padding: 4%;">{{data[0].name}}</h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 100%;background-color: #64B5F6;width: 10em;height: 3em;">
                        <h3 style="color: white;padding: 7%; text-align: center;">Last name</h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 17em;height: 3em;">
                        <h3 style="padding: 4%;">{{data[0].lastname}}</h3>
                    </v-card>
                </v-col>
            </v-row>

        </v-container>
        <!-- ////////////////////////////////////staff ID +Nickname///////////////////////////////// -->
        <v-container class="grey lighten-5" style="margin-left: 45%;padding-top: 0em;padding-bottom: 0em;">
            <v-row class="mb-6" no-gutters>
                <v-col>
                    <v-card style="width: 100%;background-color: #64B5F6;width: 10em;height: 3em;">
                        <h3 style="color: white;padding: 7%; text-align: center;">Staff ID</h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 17em;height: 3em;">
                        <h3 style="padding: 4%;">{{data[0].id}} </h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 100%;background-color: #64B5F6;width: 10em;height: 3em;">
                        <h3 style="color: white;padding: 7%; text-align: center;">Nickname</h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 17em;height: 3em;">
                        <h3 style="padding: 4%;">{{data[0].name}}</h3>
                    </v-card>
                </v-col>
            </v-row>

        </v-container>
        <!-- ////////////////////////////////////GENDER  + AGE///////////////////////////////// -->
        <v-container class="grey lighten-5" style="margin-left: 45%;padding-top: 0em;padding-bottom: 0em;">
            <v-row class="mb-6" no-gutters>
                <v-col>
                    <v-card style="width: 100%;background-color: #64B5F6;width: 10em;height: 3em;">
                        <h3 style="color: white;padding: 7%; text-align: center;">GENDER</h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 17em;height: 3em;">
                        <h3 style="padding: 4%;">Male </h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 100%;background-color: #64B5F6;width: 10em;height: 3em;">
                        <h3 style="color: white;padding: 7%; text-align: center;">AGE</h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 17em;height: 3em;">
                        <h3 style="padding: 4%;">19 years 4 months 3 days</h3>
                    </v-card>
                </v-col>
            </v-row>

        </v-container>
        <!-- ////////////////////////////////////Number ID  + Birth date///////////////////////////////// -->
        <v-container class="grey lighten-5" style="margin-left: 45%;padding-top: 0em;padding-bottom: 0em;">
            <v-row class="mb-6" no-gutters>
                <v-col>
                    <v-card style="width: 100%;background-color: #64B5F6;width: 10em;height: 3em;">
                        <h3 style="color: white;padding: 7%; text-align: center;">Number ID</h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 17em;height: 3em;">
                        <h3 style="padding: 4%;">x-xxxx-xxxxx-xx </h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 100%;background-color: #64B5F6;width: 10em;height: 3em;">
                        <h3 style="color: white;padding: 7%; text-align: center;">Birth date</h3>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card style="width: 17em;height: 3em;">
                        <h3 style="padding: 4%;">04-01-2544</h3>
                    </v-card>
                </v-col>
            </v-row>

        </v-container>
    </div>
</template>
<style>


</style>
<script>
import equipment from "@/axios/axios"
export default {
data(){
    return{
        data: null,
    }
    
},
async mounted(){
   
    const response = await equipment.get('/api/Staffs');
    console.log(response.data);
    this.data = response.data;
}
 
};
</script>