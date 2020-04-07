<template>
    <div>
        <Nav />

        <v-container class="con4">
            <h1 style="margin-left: 35%;">Personal Info & Status</h1>
            <v-row>
                <template>
                    <v-col>
                        <img src="../assets/Ellipse 7.png" style="margin-top:0%;margin-left:6%;width: 40%;" />
                    </v-col>
                    <v-col>
                        <v-container class="con3" style="background-color: white;">

                            <v-row>
                                <template>
                                    <v-col>
                                        <center>
                                            <h4>Staff ID: 62130500225</h4>
                                            <br />
                                            <h4>Name: Wirawat Jaiarree</h4>
                                        </center>
                                    </v-col>
                                    <v-col>
                                        <h4>Status: Working</h4>
                                        <br />
                                        <h4>Name(Thai): วิรวรรธ ใจอารีย์</h4>
                                    </v-col>
                                </template>
                            </v-row>
                        </v-container>

                    </v-col>
                </template>
            </v-row>
        </v-container>
        <!-- ----------------------------staff info---------------------------------------- -->
        <template style="position: absolute;height: 5%;">
            <v-card style="height: 5%;">
                <v-toolbar color="#42A5F5" dark flat prominent
                    style="margin-top: 21%;position: absolute;margin-left: 25%;height:60px;width: 50%;">

                    <template v-slot:extension>
                        <v-tabs v-model="tabs" centered style="margin-top: -35%;">
                            <v-tab>
                                Personal Info
                            </v-tab>
                            <v-tab>
                                Address
                            </v-tab>
                        </v-tabs>
                    </template>
                </v-toolbar>

                <v-tabs-items v-model="tabs">
                    <v-tab-item>
                        <v-card flat style="position: absolute;margin-top: 25%;">
                            <v-card-text>
                                <personInfo />
                                <!-- ------------------info--------------------- -->
                            </v-card-text>
                        </v-card>
                    </v-tab-item>
                    <v-tab-item>
                        <v-card flat style="position: absolute;margin-top: 25%;">
                            <v-card-text>
                                <personInfo />
                                <!-- ------------------info--------------------- -->
                            </v-card-text>
                        </v-card>
                    </v-tab-item>
                </v-tabs-items>
            </v-card>
        </template>
    </div>
</template>

<script>
    import Nav from "../components/Nav";
    import personInfo from "../views/sthOfStaff/personInfo";
    export default {
        components: {
            Nav, personInfo,
        }, data() {
            return {
                tabs: null,
                text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
            }
        }
    };
</script>
<style>
    .con3 {
        position: absolute;
        border-radius: 1em;
        box-shadow: 5px 0px 10px #888888;
        border: 2px #9d9d9d;
        width: 70%;
        height: 20vh;
        margin-left: -25%;
    }

    .con4 {
        position: absolute;
        border-radius: 1em;
        box-shadow: 5px 0px 10px #888888;
        border: 2px #9d9d9d;
        width: 50%;
        height: 35vh;
        margin-left: 25%;
        margin-top: 3%;
        background-color: #E3F2FD;
    }

    
</style>