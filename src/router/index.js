import Vue from "vue";
import VueRouter from "vue-router";
// import Home from "../views/Home.vue";
// import Nav from "../components/Nav";
import staff from "../views/staff";
import Registerr from "../views/Registerr";
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
  }, {
    path: "/",
    name: "Logout",
    component: () =>
      import("../views/Logout.vue")
  },
  {
    path: "/info",
    name: "info",
    component: () =>
      import("../views/info.vue")
  }
  , {
    path: "/request",
    name: "request",
    component: () =>
      import("../views/request.vue")
  }, {
    path: "/allStaff",
    name: "allStaff",
    component: () =>
      import("../views/allStaff.vue")
  }, {
    path: "/loginv1",
    name: "loginv1",
    component: () =>
      import("../views/loginv1.vue")
  }, {
    path: "/Registerr",
    name: "Registerr",
    component: Registerr

  }



];

const router = new VueRouter({
  routes
});

export default router;
