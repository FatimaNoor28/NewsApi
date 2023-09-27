<template>
  <div class="news-card" @click="openArticle(article.url)">
    <header>
      <img v-if="article.image" :src="article.image" alt="">
      <img v-else class="fas fa-image" :src="getArticleImage(article, index)" alt="dummy image">
      <!-- <img :src="getArticleImage(article)" alt=""> -->
    </header>

    <div class="content">
      <h2>{{ article.title }}</h2>
      <p>{{ article.pub_date }}</p>
      <!-- <p>Category: {{ category }}</p> -->
    </div>
    <div class="footer">
      <i class="fas fa-chevron-right"></i>
    </div>
  </div>
</template>
  
<script>

export default {
  name: 'NYCategoryCard',
  props: {
    index: Number,
    article: Object, // The news article data as a prop
    category: String
  },
  data() {
    return {
      newsItems: [],

      cardImages: [
        "1.jpg",
        "2.jpg",
        "3.jpg",
        "4.jpg",
        "5.jpg",
        "6.jpg",
        "7.jpg",
        "8.jpg",
        "9.jpg",
        "10.jpg",
        "11.jpg",
        "12.jpg",
        "13.jpg",
        "14.jpg",
        "15.jpg",
        "16.jpg",
        "17.jpg",
        "18.jpg",
        "19.jpg",
        "20.jpg"

      ],
    };
  },
  methods: {
    getArticleImage(article, index) {
      console.log(index);
      if (this.cardImages.length === 0) {
        return null; // Return null if there are no images
      }
      // If article.image is not defined or is an empty string, use the default image
      if (!article.image || article.image.trim() === "") {
        const effIndex = index % this.cardImages.length;
        // const imageNumber = this.imageIndex % 10 + 1;
        const image = `/assets/${this.category}/${this.cardImages[effIndex]}`;
        console.log("image: ", image);
        return image;
      }

      return article.image;
    },
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
  