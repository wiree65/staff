import Vue from "vue";
import VueRouter from "vue-router";
import staff from "../views/staff/staff";
import register from "../views/manager/register";
import allWork from "../views/manager/allWork";
import manager from "../views/manager/manager";
// import loginv1 from "../views/loginv1";//

Vue.use(VueRouter);
// const $auth = false;
const routes = [
  {
    path: "/homepage",
    name: "staff",
    component: staff
  },
  {
    path: "/allWork",
    name: "allWork",
    component: allWork
  },
  {
    path: "/info",
    name: "info",
    component: () =>
      import("../views/staff/info.vue")
  }
  , {
    path: "/request",
    name: "request",
    component: () =>
      import("../views/staff/request.vue")
  }, {
    path: "/",
    name: "loginv1",
    component: () =>
      import("../views/loginv1.vue")
  }, {
    path: "/register",
    name: "register",
    component: register
  }, 
  {
    path: "/manager",
    name: "manager",
    component: manager
  }
 
];

const router = new VueRouter({
  routes
});

export default router;
