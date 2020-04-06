<template>
  <div >
    <Nav/>
    <Calendar/>
    <div class="grid-container">
    </div>
  </div>
</template>
<script>
import Nav from "../components/Nav";
import Calendar from "../components/calendar";
export default {
 components: {
      Nav,Calendar
    }
}
</script>
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
