import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import ContactForm from "../views/Contact.vue";
import About from "../views/About.vue";
import LogIn from "@/views/LogIn";
import Register from "@/views/Register";
import NotFound from "@/views/NotFound";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/contact",
    name: "ContactForm",
    component: ContactForm,
  },
  {
    path: "/about",
    name: "About",
    component: About,
  },
  {
    path: "/login",
    name: "LogIn",
    component: LogIn,
  },
  {
    path: "/register",
    name: "Register",
    component: Register,
  },
  {
    path: "/:catchAll(.*)",
    name: "NotFound",
    component: NotFound,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
