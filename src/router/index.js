import Vue from "vue";
import VueRouter from "vue-router";
<<<<<<< HEAD
// import Home from "../views/Home.vue";
// import Nav from "../components/Nav";
import staff from "../views/staff";
import register from "../views/register";
import register1 from "../views/Registerr";
import allWork from "../views/allWork";
import designLogin from "../views/designLogin";
=======
import staff from "../views/staff/staff";
import register from "../views/manager/register";
import allWork from "../views/manager/allWork";
import manager from "../views/manager/manager";
import getRequest from "../views/staff/getRQ/getRequest";
import requestForm from "../views/staff/requestForm";
import approve from "../views/manager/request/approve";
import getRequestStaff from "../views/manager/request/getRequestStaff";
import unconfirmed from "../views/manager/request/unconfirmed";
import calendar from "../views/staff/calendar";
import info1 from "../views/manager/info";

>>>>>>> master
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
      import("../views/staff/getRQ/request")
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
  },
  {
    path: "/getRequest",
    name: "getRequest",
    component: getRequest
  }, {
    path: "/requestForm",
    name: "requestForm",
    component: requestForm
  }, {
<<<<<<< HEAD
    path: "/register1",
    name: "register1",
    component: register1
  }, {
    path: "/designLogin",
    name: "designLogin",
    component: designLogin
=======
    path: "/approve",
    name: "approve",
    component: approve
  },{
    path: "/calendar",
    name: "calendar",
    component: calendar
  },{
    path: "/info1",
    name: "info1",
    component: info1
  },{
    path: "/getRequestStaff",
    name: "getRequestStaff",
    component: getRequestStaff
  },{
    path: "/unconfirmed",
    name: "unconfirmed",
    component: unconfirmed
>>>>>>> master
  }
 
];

const router = new VueRouter({
  routes
});

export default router;
