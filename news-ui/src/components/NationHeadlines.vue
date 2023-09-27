<!-- NewsList.vue -->
<template>
    <div>
     <NationNavFooter />
   </div>
   <div>
    <h1>The Nation News Headlines</h1>
     <div class="news-cards">
      <br>
      <br>
       <div class="item" v-if="articles.length > 0">
         <NationNewsCard v-for="(article, index) in articles" :key="index" :index="index" :article="article"
           :category="category">
         </NationNewsCard>
       </div>     </div>
   </div>
  </template>
   
  <script>
  import NewsService from '../services/NewsService.js';
  import NationNavFooter from './NationNavFooter.vue';
import NationNewsCard from './NationNewsCard.vue';
  export default {
  
   name: 'NewsList',
   components: {
    NationNavFooter,
    NationNewsCard
},
   data() {
     return {
       totalResults: 0,
       articles: [] // Initialize with an empty array to store news data
     };
   },
   mounted() {
     this.fetchNewsData();
   },
   methods: {
    //  getNews(category) {
    //    console.log("passing category to Nation Categories page: ", category);
    //    this.$router.push({name:'NationCategories', query: { category: category }});
    //  },
     fetchNewsData() {
       NewsService.getNationNews()
         .then((response) => {
           if (response && response.data) {
             // Check if response and response.data are defined
             this.totalResults = response.data.totalResults;
             this.articles = response.data;
           } else {
             console.error('Invalid API response:', response);
           }
         })
         .catch((error) => {
           console.log(error);
         })
     },
   }
  }
  </script>
   
  <style scoped>
  /* Add styles for category selector and news cards container here */
  .category-selector {
   display: flex;
   justify-content: center;
   margin-bottom: 20px;
  }
  
  .category-selector button {
   background-color: #007BFF;
   color: #fff;
   border: none;
   padding: 10px 20px;
   margin: 0 10px;
   cursor: pointer;
   transition: background-color 0.3s;
  }
  
  .category-selector button:hover {
   background-color: #0056b3;
  }
  
  .news-cards {
   display: flex;
   flex-wrap: wrap;
   justify-content: center;
  }
  </style>
   