<!-- NewsList.vue -->
<template>
  
  <div>
    <div class="category-selector">
      <button @click="getHealthNews" class="btn btn-primary"
        style=" outline-color: rgb(82, 54, 20);  margin-left:1cm; margin-top:2cm; height:1.5cm; width:5cm; background-color: #7da4ad; font-size:21px; font-family:'Times New Roman', Times, serif">
        Health News</button>
      <!-- Add buttons or links for categories here -->
    </div>
    <div class="news-cards">
      <news-card v-for="(article, index) in articles" :key="index" :article="article"></news-card>
      <!-- <news-card v-for="article in articles" :key="article.title" :article="article" /> -->
    </div>
  </div>
</template>
  
<script>
import NewsCard from './NewsCard.vue';
import NewsService from '../services/NewsService.js';
export default {

  name: 'NewsList',
  components: {
    NewsCard
  },
  data() {
    return {
      totalResults: 0,
      articles: [] // Initialize with an empty array to store news data
    };
  },
  mounted() {
    // Fetch news data from your Spring Boot backend (you may need to set up an API endpoint for this)
    // Once you have the data, update the 'articles' data property
    this.fetchNewsData();
  },
  methods: {
    // openArticle(url) {
    //   console.log("clicked on article");
    //   window.open(url);
    // },
    getHealthNews() {
      // Toggle the balance view
      // NewsService.getHealthNews("health")
      this.$router.push({name:'NYCategories'});
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
      // .then((response) => {
      //       this.articles = response.data;
      //     })
      //     .catch((error) => {
      //       console.error('Error fetching news:', error);
      //     });
    },
    // Make an HTTP request to your Spring Boot backend to fetch news data
    // Update the 'articles' property with the fetched data
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
  