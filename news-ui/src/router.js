import NewsUI from "./components/News.vue"

import { createRouter, createWebHistory } from "vue-router";


const routes = [
    {
      name: "News",
      component: NewsUI,
      path: "/news",
    }, 
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  });
  
  
  export default router;
  