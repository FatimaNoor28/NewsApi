<!-- NewsList.vue -->
<template>
  <div>
   <NYNavFooter />
 </div>
 <div>
   <div class="news-cards">
     <news-card v-for="(article, index) in articles" :key="index" :article="article"></news-card>
   </div>
 </div>
</template>
 
<script>
import NewsCard from './NYNewsCard.vue';
import NewsService from '../services/NewsService.js';
import NYNavFooter from './NYNavFooter.vue';
export default {

 name: 'NewsList',
 components: {
   NewsCard,
   NYNavFooter,
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
   getNews(category) {
     console.log("passing category to NY Categories page: ", category);
     this.$router.push({name:'NYCategories', query: { category: category }});
   },
   fetchNewsData() {
     NewsService.getNews()
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
 