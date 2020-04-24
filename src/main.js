import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import vuetify from "./plugins/vuetify";
import '@fortawesome/fontawesome-free/css/all.css' 
Vue.prototype.$auth = false;
Vue.config.productionTip = false;
new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount("#app");
export default new vuetify({
  icons: {
    iconfont: 'fa',
  },
})
