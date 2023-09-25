<!-- NewsCard.vue -->
<template>
    <div class="news-card" @click="openArticle(article.link)">
      <header>
        <img v-if="article.image_url" :src="article.image_url" alt="">
        <i v-else class="fas fa-image">dummy image</i>
      </header>
  
      <div class="content">
        <h2>{{ article.title }}</h2>
        <p>{{ article.pubDate }}</p>
      </div>
      <div class="footer">
        <i class="fas fa-chevron-right"></i>
      </div>
      <!-- <h2>{{ article.title }}</h2>
        <p>{{ article.description }}</p>
        <img :src="article.urlToImag" alt="" > -->
    </div>
  </template>
    
  <script>
  export default {
    props: {
      article: Object // The news article data as a prop
    },
    methods: {
      openArticle(url) {
        window.open(url);
      }
    }
  }
  </script>
    
  <style scoped>
  /* Add styles for your news card here */
  .news-card {
    display: grid;
    grid-template-columns: 200px auto 40px;
    grid-template-rows: 100px;
    border-bottom: 1px solid #ccc;
    overflow: hidden;
    cursor: pointer;
  }
  
  .news-card:hover {
    background-color: #f0f0f0;
  }
  
  header {
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
  
    img {
      max-width: 100%;
      height: auto;
    }
  
    i {
      font-size: 2rem;
    }
  }
  
  .content h2 {
    font-size: 1.2rem;
    margin-top: 10px;
  }
  
  .content p {
    margin-top: 10px;
  }
  
  .footer {
    display: flex;
    justify-content: flex-end;
  }
  
  </style>
    