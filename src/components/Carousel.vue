<template>
  <!-- <v-carousel cycle
    height="250"
    hide-delimiter-background
    show-arrows-on-hover>
    <v-carousel-item
      v-for="(item,i) in items "
      :key="i"
      :src="item.src"
      
    ></v-carousel-item>
    
  </v-carousel> -->
  <!-- old height is 250 -->
  <v-carousel
    cycle
    height="100%"
    hide-delimiter-background
    show-arrows-on-hover
  >
    <v-carousel-item
      v-for="(item, i) in items"
      :key="i"
      :src="item.src"
    >

        <!-- <v-row
          class="fill-height"
          align="center"
          justify="center"
        >
          <div class="display-3">{{ slide }} </div> -->
        <!-- </v-row> -->
    </v-carousel-item>
  </v-carousel>
</template>
<script>
  export default {
    data () {
      return {
        items: [
          {
            src: require("../assets/announce01.jpg"),
          },
          {
            src: require("../assets/announce02.jpg"),
          },
          {
            src: require("../assets/announce03.jpg"),
          },
        ],colors: [
          'indigo',
          'indigo',
          'indigo',
          'indigo',
          'indigo',
        ],
        slides: [
          'Annoncement 1',
          'Annoncement 2',
          'Annoncement 3',
          'Annoncement 4',
          'Annoncement 5',
        ],
      }
    }
  }
</script>