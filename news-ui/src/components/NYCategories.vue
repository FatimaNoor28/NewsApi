<template>
 <div>
  <NYNavFooter />
 </div>
  <div class="news-cards">
    <h1>News Section</h1>
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
      console.log("in categories: ", this.category);
      const response1 = await NewsService.getNewsType(this.category, 1);
      console.log("in categories: service called");
      console.log(response1.data);
      this.articles = response1.data;
      const response2 = await NewsService.getNewsType(this.category, 2);
      console.log("in categories: service called");
      console.log(response2.data);
      this.articles = this.articles.concat(response2.data); // Append data from page 2 to existing articles
      // .then((response) => {
      //   console.log("in categories: service called");
      //   console.log(response.data);
      //   this.articles = response.data;

      // })
      // .catch((error) => {
      //   console.error("Error fetching data:", error);
      //   console.log("in categories: error");
      // });
      await NewsService.getNewsType(this.category, 2)
        .then((response) => {
          console.log("in categories: service called");
          console.log(response.data);
          this.articles.concat(response.data);
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