import NewsUI from "./components/News.vue"
import NewsList from "./components/NewsList.vue"

import { createRouter, createWebHistory } from "vue-router";


const routes = [
    {
      name: "News",
      component: NewsUI,
      path: "/news",
    }, 
    {
      name: "NewsList",
      component: NewsList,
      path: "/getNews",
    }, 
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  });
  
  
  export default router;
  