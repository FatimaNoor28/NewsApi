<template>
  <div class="news-card" @click="openArticle(article.url)">
    <header>
      <img v-if="article.imageUrl" :src="article.imageUrl[1]" alt="">
      <i v-else class="fas fa-image">dummy image</i>
    </header>

    <div class="content">
      <h2>{{ article.title }}</h2>
      <p>{{ article.abstract }}</p>
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
// import NewsService from "../services/NewsService";

export default {
  name: 'NYCategoryCard',
  props: {
    article: Object // The news article data as a prop
  },
  methods: {
    openArticle(url) {
      window.open(url);
    }
  }
};
</script>
  
<style scoped>
/* Add any custom styling you need for your news cards here */
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

/* .news-card header {
  text-align: center;
} */

/* .header {
  text-align: center;
}

.header img {
  max-width: 100%;
  height: auto;
} */


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
  