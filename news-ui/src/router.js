// import NewsUI from "./components/News.vue"
import NYNewsList from "./components/NYNewsList.vue"
import NYCategories from "./components/NYCategories.vue" 
// import NYCategoryCard from "./components/NYCategoryCard.vue";
// import NYNews from "./components/NYNews.vue";
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
  