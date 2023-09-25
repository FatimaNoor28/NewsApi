<template>
    <div>
     <NationNavFooter />
    </div>
     <div class="news-cards">
       <h1>News Section</h1>
       <div class="item" v-if="articles.length > 0">
         <NationCategoryCard v-for="(article, index) in articles" :key="index" :index="index" :article="article"
           :category="category">
         </NationCategoryCard>
       </div>
     </div>
   </template>
       
   <script>
   import NewsService from "../services/NewsService"
   import NationCategoryCard from "./NationCategoryCard.vue"; // Import the NewsCard component
import NationNavFooter from "./NationNavFooter.vue";
   export default {
     name: 'NationCategories',
     data() {
       return {
         articles: [],
         totalResults: 0,
         category: '',
       };
     },
     components: {
    NationCategoryCard,
    NationNavFooter
},
     mounted() {
       console.log("in categories mounted");
       this.fetchNews(this.category);
     },
     created() {
       this.category = this.$route.query.category;
       // Use the 'category' variable in your component logic
       console.log(`Category received: ${this.category}`);
     },
     watch: {
       $route(to, from) {
         if (to.query.category !== from.query.category) {
           this.category = to.query.category;
           this.fetchNews(this.category);
         }
       },
     },
     methods: {
   
       async fetchNews(category) {
         this.category = category;
   
         await NewsService.getNationNewsType(this.category)
           .then((response) => {
             console.log("in categories: service called");
             console.log(response.data);
             this.articles= response.data;
             this.totalResults = response.data.length;
             // this.articles = response.data;
   
           })
           .catch((error) => {
             console.error("Error fetching data:", error);
             console.log("in categories: error");
           });
       },
     },
   };
   </script>
       
   <style>
   .navbar {
     margin-top: -1.5cm;
     background-color: black;
   
   }
   
   #item {
     color: white;
     font-size: 21px;
     font-family: Major Mono Display;
     padding-left: 1cm;
   
   }
   </style>