import Vue from "vue";
import VueRouter from "vue-router";
// import Home from "../views/Home.vue";
// import Nav from "../components/Nav";
import staff from "../views/staff";
import register from "../views/register";
import register1 from "../views/Registerr";
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
    path: "/",
    name: "loginv1",
    component: () =>
      import("../views/loginv1.vue")
  }, {
    path: "/register",
    name: "register",
    component: register
  }, {
    path: "/register1",
    name: "register1",
    component: register1
  }
 
];

const router = new VueRouter({
  routes
});

export default router;
