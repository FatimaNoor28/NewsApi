<!-- NewsList.vue -->
<template>
    <div>
      <div class="category-selector">
        <!-- Add buttons or links for categories here -->
      </div>
      <div class="news-cards">
        <news-card v-for="article in articles" :key="article.title" :article="article" />
      </div>
    </div>
  </template>
  
  <script>
  import NewsCard from './NewsCard.vue';
  
  export default {
    components: {
      NewsCard
    },
    data() {
      return {
        articles: [] // Initialize with an empty array to store news data
      };
    },
    mounted() {
      // Fetch news data from your Spring Boot backend (you may need to set up an API endpoint for this)
      // Once you have the data, update the 'articles' data property
      this.fetchNewsData();
    },
    methods: {
      fetchNewsData() {
        NewsService.getNews().then((response) => {
                this.articles = response.data;
            });
        },
        // Make an HTTP request to your Spring Boot backend to fetch news data
        // Update the 'articles' property with the fetched data
      }
    }
  </script>
  
  <style scoped>
  /* Add styles for category selector and news cards container here */
  .category-selector {
    /* Styles for category selection buttons or links */
  }
  
  .news-cards {
    /* Styles for the container of news cards */
  }
  </style>
  