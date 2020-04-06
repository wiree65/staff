<template>
  <div class="grid-container">
    <div class="grid-item1">
      <img src="../assets/logo.png" class="logo">
      <h1 class="h1">Computer Science Banking</h1>
    </div>
    <div class="grid-item2">
      <h2 style="position: absolute;color: #5A5A5A;font-size: 300%;margin-left: 6%;margin-top: 8%;font-weight: 500;">CSB
        Staff Login </h2>
      <img src="../assets/account 1.png" style="position: absolute;width: 2%;margin-top: 14%;margin-left: 6%;">
      <img src="../assets/key-variant 1.png" style="position: absolute;width: 1.7%;margin-top: 17%;margin-left: 6%;">
      <input type="text" name="user" placeholder="username" /><br /><br />
      <input type="password" name="user" placeholder="password" /><br />
      <router-link to="/homepage">
        <v-btn large color="#1E88E5"
          style="position: absolute;width: 8%;height: 5.5%;margin-left: 20.5%;margin-top: 17%;border-radius: 50px;">
          <p style="color: white;margin-top: 10%;font-size:150%;">LOGIN</p>
        </v-btn>
      </router-link>
    </div>

  </div>



</template>
<style>
  input {
    position: absolute;
    border: none;
    border-bottom: 2px solid #7D8789;
    ;
    margin-top: 14%;
    margin-left: 8.5%;
    width: 20%;

  }

  .grid-container {
    display: grid;
    margin-top: 7%;
    position: #888888;
    border: 2px #9d9d9d;
    width: 70%;
    height: 70%;
    margin-left: 15%;
    grid-template-columns: auto auto;


  }

  .grid-item1 {
    border-top-left-radius: 1em;
    background-color: #1E88E5;
    border-bottom-left-radius: 1em;
    box-shadow: 5px 0px 10px #888888;

  }

  .grid-item2 {
    border-top-right-radius: 1em;
    background-color: white;
    border-bottom-right-radius: 1em;
    box-shadow: 5px 0px 10px #888888;

  }

  .logo {
    position: absolute;
    width: 25%;
    margin-top: 9%;
    margin-left: 5%
  }

  .h1 {
    position: absolute;
    color: white;
    margin-top: 22%;
    margin-left: 5%;
  }
</style>