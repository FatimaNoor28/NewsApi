<template>
 <div>
  <NYNavFooter />
 </div>
  <div class="news-cards">
    <h1>{{this.category}} news section</h1>
    <div class="item" v-if="articles.length > 0">
      <NYCategoryCard v-for="(article, index) in articles" :key="index" :index="index" :article="article"
        :category="category">
      </NYCategoryCard>
    </div>
  </div>
</template>
    
<script>
import NewsService from "../services/NewsService"
import NYCategoryCard from "./NYCategoryCard.vue"; // Import the NewsCard component
import NYNavFooter from "./NYNavFooter.vue";
export default {
  name: 'NYCategories',
  data() {
    return {
      articles: [],
      totalResults: 0,
      category: '',
    };
  },
  components: {
    NYCategoryCard,
    NYNavFooter,
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

      await NewsService.getNewsType(this.category)
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