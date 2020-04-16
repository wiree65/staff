<template>
  <nav>
    <v-app-bar app color="blue darken-2" light>
      <v-app-bar-nav-icon @click="drawer=!drawer"></v-app-bar-nav-icon>
      <router-link to="/homepage" style="color: black;">
        <v-img src="../assets/logo.png" max-width="60px" class="mr-3"></v-img>
      </router-link>
      <v-toolbar-title class="d-flex align-center title1">CS Banking</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn @click="logout">Log out</v-btn>
    </v-app-bar>


    <v-navigation-drawer v-model="drawer" absolute bottom temporary style="width: 15%;">
      <v-list flat>
        <v-list-item-group v-model="item" color="black">
          <router-link :to="item.link" v-for="(item, i) in items" :key="i" style="text-decoration: none;color: black;">
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title v-text="item.text"></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </router-link>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
  </nav>
</template>
<style>
  .v-toolbar__title {
    font-size: 1.6em;
    line-height: 1.5;
    overflow: hidden;
    overflow-x: hidden;
    overflow-y: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-weight: 900;
  }
</style>

<script>
  import auth from "../auth";
  export default {
    name: "Nav",

    data() {
      return {
        drawer: false,
        item: 1,
        items: [
          { text: "Home", link: "/homepage" },
          { text: "Personal & Status", link: "/info" },
          { text: "Approve Cheque", link: "/Open" },
          { text: "Request Form", link: "/Open" },
          { text: "Calendar", link: "/Open" },
          { text: "Log out", link: "/" }
        ]
      };
    },
    methods:{
      logout(){
        auth.logout();
        this.$router.push('/');
      }
    }
  };
</script>