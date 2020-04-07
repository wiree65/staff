import Vue from "vue";
import VueRouter from "vue-router";
// import Home from "../views/Home.vue";
// import Nav from "../components/Nav";
import staff from "../views/staff";
Vue.use(VueRouter);

const routes = [
  {
    path: "/homepage",
    name: "staff",
    component: staff
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
  },{
    path: "/info",
    name: "info",
    component: () =>
        import( "../views/info.vue")
  }
];

const router = new VueRouter({
  routes
});

export default router;
