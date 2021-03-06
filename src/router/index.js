import Vue from "vue";
import VueRouter from "vue-router";
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
import calendar1 from "../views/manager/calendar/2getCalendar";

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
      import("../views/designLogin.vue")
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
  },{
    path: "/calendar1",
    name: "calendar1",
    component: calendar1
  }
 
];

const router = new VueRouter({
  routes
});

export default router;
