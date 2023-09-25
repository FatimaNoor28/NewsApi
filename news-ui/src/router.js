import NYNewsList from "./components/NYNewsList.vue"
import NYCategories from "./components/NYCategories.vue" 
import NationHeadlines from "./components/NationHeadlines.vue"
import NationCategories from "./components/NationCategories.vue";
import { createRouter, createWebHistory } from "vue-router";


const routes = [
    // {
    //   name: "News",
    //   component: NewsUI,
    //   path: "/news",
    // }, 
    {
      name: "NewsList",
      component: NYNewsList,
      path: "/news/nyTimes",
    }, 
    {
      name: "NYCategories",
      component: NYCategories,
      path: "/news/nyTimes/category",
    }, 
    {
      name: "NationHeadlines",
      component: NationHeadlines,
      path: "/news/nation",
    }, 
    {
      name: "NationCategories",
      component: NationCategories,
      path: "/news/nation/category",
    }, 
    // {
    //   name: "NY-News",
    //   component: NYNews,
    //   path: "/news/nyTimes",
    // }, 
]

const router = createRouter({
    history: createWebHistory(),
    routes,
  });
  
  
  export default router;
  