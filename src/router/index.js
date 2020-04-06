import Vue from "vue";
import VueRouter from "vue-router";
// import Home from "../views/Home.vue";
// import Nav from "../components/Nav";
import homepage from "../router/homepage";
Vue.use(VueRouter);

const routes = [
  {
    path: "/homepage",
    name: "homepage",
    component: homepage
  },
  {
    path: "/about",
    name: "About",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  },{
  path: "/",
  name: "Logout",
  component: () =>
      import( "../views/Logout.vue")
  }
];

const router = new VueRouter({
  routes
});

export default router;
