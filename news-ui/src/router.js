import NewsUI from "./components/News.vue"
import NewsList from "./components/NewsList.vue"
import NYCategories from "./components/NYCategories.vue" 
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
    {
      name: "NYCategories",
      component: NYCategories,
      path: "/category",
    }, 
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  });
  
  
  export default router;
  