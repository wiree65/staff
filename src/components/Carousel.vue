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
  <v-carousel
    cycle
    height="250"
    hide-delimiter-background
    show-arrows-on-hover
  >
    <v-carousel-item
      v-for="(slide, i) in slides"
      :key="i"
    >
      <v-sheet
        :color="colors[i]"
        height="100%"
      >
        <v-row
          class="fill-height"
          align="center"
          justify="center"
        >
          <div class="display-3">{{ slide }} </div>
        </v-row>
      </v-sheet>
    </v-carousel-item>
  </v-carousel>
</template>
<script>
  export default {
    data () {
      return {
        items: [
          {
            src: require('../assets/announce1.png'),
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg',
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg',
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg',
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