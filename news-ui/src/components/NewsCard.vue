<!-- NewsCard.vue -->
<template>
    <div class="news-card">
      <h2>{{ article.title }}</h2>
      <p>{{ article.description }}</p>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      article: Object // The news article data as a prop
    }
  }
  </script>
  
  <style scoped>
  /* Add styles for your news card here */
  .news-card {
    background-color: #fff;
    border: 1px solid #ccc;
    padding: 20px;
    margin: 10px;
  }
  </style>
  