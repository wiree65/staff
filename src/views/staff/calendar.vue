<template>
  <div>
    <Nav/>
    <v-sheet height="600">
      <v-calendar
        ref="calendar"
        v-model="value"
        :weekdays="weekday"
        :type="type"
        :events="events"
        :event-overlap-mode="mode"
        :event-overlap-threshold="30"
      
      ></v-calendar>
    </v-sheet>
  </div>
</template>

<script>
import Nav from "../../components/Nav";
  export default {
    components:{
      Nav
    },
    data: () => ({
    
      value: '',
      events: [
        {
          name: 'Weekly Meeting',
          start: '2020-04-21',
          end: '2020-04-07',
        },
        {
          name: 'Thomas\' Birthday',
          start: '2020-04-10',
        },
        {
          name: 'Mash Potatoes',
          start: '2020-04-09',
          end: '2020-04-09',
        }],
    

      
    }),
   

  
  }
</script>