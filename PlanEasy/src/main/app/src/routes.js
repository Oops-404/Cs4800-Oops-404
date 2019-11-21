/*!

=========================================================
* Material Dashboard React - v1.8.0
=========================================================

* Product Page: https://www.creative-tim.com/product/material-dashboard-react
* Copyright 2019 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://github.com/creativetimofficial/material-dashboard-react/blob/master/LICENSE.md)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/
// @material-ui/icons
import Person from "@material-ui/icons/Person";
// core components/views for Admin layout
import UserProfile from "views/UserProfile/UserProfile.js";
// core components/views for RTL layout
import EventList from "views/EventList/EventList.js";
import Calendar from "views/Calendar/Calendar.js";
import Home from "views/Home/Home";

const dashboardRoutes = [
  {
    path: "/home",
    name: "Home",
    rtlName: "قائمة الجدول",
    icon: "dashboard",
    component: Home,
    layout: "/admin"
  },
  // {
  //   path: "/user",
  //   name: "User Profile",
  //   rtlName: "ملف تعريفي للمستخدم",
  //   icon: Person,
  //   component: UserProfile,
  //   layout: "/admin"
  // },
  {
    path: "/event",
    name: "Event List",
    rtlName: "قائمة الجدول",
    icon: "content_paste",
    component: EventList,
    layout: "/admin"
  },
  {
    path: "/calendar",
    name: "Calendar",
    rtlName: "قائمة الجدول",
    icon: "calendar_today",
    component: Calendar,
    layout: "/admin"
  },

];

export default dashboardRoutes;
