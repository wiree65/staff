<template>
    <div>
        <!-- ////////////////////////////////////address///////////////////////////////// -->
        <v-container>

            <v-row>
                <v-col xs="2" md="2" class="col">
                </v-col>
                <v-col xs="1" md="1" class="col">
                    <v-card style="background-color: #64B5F6;height: 7em;" class="vcard">
                        <h3 class="h3">First Address</h3>
                    </v-card>
                </v-col>
                <v-col xs="7" md="7">
                    <v-card style="height: 7em;" class="vcardb">
                        <h3>{{data[0].name}}</h3>
                    </v-card>
                </v-col>
                
            </v-row>
        </v-container>
        <v-container>

            <v-row>
                <v-col xs="2" md="2" class="col">
                </v-col>
                <v-col xs="1" md="1" class="col">
                    <v-card style="background-color: #64B5F6;height: 7em;" class="vcard">
                        <h3 class="h3">First Address</h3>
                    </v-card>
                </v-col>
                <v-col xs="7" md="7">
                    <v-card style="height: 7em;" class="vcardb">
                        <h3>{{data[0].name}}</h3>
                    </v-card>
                </v-col>
                
            </v-row>
        </v-container>
    </div>
</template>
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