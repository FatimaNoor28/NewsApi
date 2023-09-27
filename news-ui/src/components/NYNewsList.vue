<!-- NewsList.vue -->
<template>
  <div>
    <NYNavFooter />
  </div>
  <br><br>
  <div class="container container-fluid">


    <div class="row">
      <h3 style="text-align: left;">Latest News</h3>
      <hr style="border: none;
            border-top: 4px solid black;
            margin-bottom: 10px 0; ">
    </div>
    <!-- THIS IS TOP DIV -->
    <h3>top div</h3>

    <div v-if="articles.length > 0" class="top-div row">

      <div class="left-top-div col-6" style="max-height: 90%;">
        <a :href="articles[0].url" style="text-decoration: none;">
          <div class="card text-center" style="border: none;">
            <img class="card-img-top" :src="articles[0].image" alt="Card image cap" style="max-height: 50%;">
            <div class="card-body">
              <p class="text-md">{{ articles[0].title }}</p>
              <p class="text-sm"><strong>{{ articles[0].published_date }}</strong></p>
            </div>
          </div>
        </a>

      </div>

      <div class="mid-top-div col-3">
        <div class="up-div" style="max-height: 45%; overflow: hidden;">
          <a :href="articles[1].url" style="text-decoration: none;">
            <div class="card text-center" style="border: none;">
              <img class="card-img-top img-fluid" :src="articles[1].image" alt="Card image cap">
              <div class="card-body" :class="{ 'hovered': isHovered }">
                <p class="text-md">{{ articles[1].title }}</p>
                <p class="text-md"><strong>{{ articles[1].published_date }}</strong></p>
              </div>
            </div>
          </a>

        </div>

        <div class="down-div" style="max-height: 45%; overflow: hidden;">
          <a :href="articles[2].url" style="text-decoration: none;">
            <div class="card text-center" style="border: none;">
              <img class="card-img-top img-fluid" :src="articles[2].image" alt="Card image cap">
              <div class="card-body">
                <p class="text-md">{{ articles[2].title }}</p>
                <p class="text-md"><strong>{{ articles[2].published_date }}</strong></p>
              </div>
            </div>
          </a>

        </div>
      </div>

      <div class="right-top-div col-3">
        <div class="up-div" style="max-height: 45%; overflow: hidden;">
          <a :href="articles[3].url" style="text-decoration: none;">
            <div class="card text-center" style="border: none;">
              <img class="card-img-top" :src="articles[3].image" alt="Card image cap">
              <div class="card-body" :class="{ 'hovered': isHovered }">
                <p class="text-md">{{ articles[3].title }}</p>
                <p class="text-md"><strong>{{ articles[3].published_date }}</strong></p>
              </div>
            </div>
          </a>

        </div>

        <div class="down-div" style="max-height: 45%; overflow: hidden;">
          <a :href="articles[4].url" style="text-decoration: none;">
            <div class="card text-center" style="border: none;">
              <img class="card-img-top" :src="articles[4].image" alt="Card image cap">
              <div class="card-body" :class="{ 'hovered': isHovered }">
                <p class="text-md">{{ articles[4].title }}</p>
                <p class="text-md"><strong>{{ articles[4].published_date }}</strong></p>
              </div>
            </div>
          </a>

        </div>
      </div>
    </div>


    <!-- THIS IS MIDDLE DIV -->
    <h3>mid div</h3>


    <hr style="border: 1px solid #000;">
    <div v-if="articles.length >= 8" class="middle-div d-flex align-items-stretch row" style="margin-top: 30px;">
      <div v-for="(article, index) in articles.slice(5, 9)" :key="index" class="left-div-middle col-sm-3">
        <a :href="article.url" style="text-decoration: none;">
          <div class="card text-center" style="border: none;">
            <img class="card-img-top" :src="article.image" alt="Card image cap" style="max-height: 50%;">
            <div class="card-body">
              <p class="text-md">{{ article.title }}</p>
              <p class="text-md"><strong>{{ article.published_date }}</strong></p>
            </div>
          </div>
        </a>
      </div>
    </div>


    <!-- THIS IS BOTTOM DIV -->

    <h3>bottom div</h3>

    <div v-if="articles.length >= 9" class="bottom-div" style="margin-top: 10px; margin-bottom: 20px;">
      <div class="card text-center" style="border: none;">
        <img class="card-img-top" :src="articles[9].image" alt="Card image cap" style="max-height: 300px;">
        <div class="card-body">
          <p class="text-md">{{ articles[9].title }}</p>
          <p class="text-md"><strong>{{ articles[9].published_date }}</strong></p>
        </div>
      </div>

    </div>
    <!-- THIS IS last DIV -->
<h3>Last div</h3>
    <br><br>
    <hr style="border: 1px solid #000;">
    <div class="last-div row" style="margin-top: 20px;">
      <div class="last-div-left col-5">
        <div v-for="(article, index) in firstHalfItems" :key="index">
          <a :href="article.url" style="text-decoration: none;">
            <div class="col-5">
                <div>
                  <img :src="article.image" alt="Card image cap" style="max-width: 90%; max-height: 100%;">
                </div>
              </div>
            <h6 style="color:black;">{{ article.title }}</h6>
            <p class="text-md"><strong>{{ article.published_date }}</strong></p>
          </a>

          <hr>
        </div>
      </div>


      <div class="last-div-right col-5" style="margin-left: 40px; border-left: 1px solid #000;">
        <div v-for="(article, index) in secondHalfItems" :key="index">
          <a :href="article.url" style="text-decoration: none;">
            <div class="row" style="max-height: 200px; margin-top: 10px;">
              <div class="col-5">
                <div>
                  <img :src="article.image" alt="Card image cap" style="max-width: 90%; max-height: 100%;">
                </div>
              </div>
              <div class="col-5">
                <div>
                  <p style="max-width: 90%; max-height: 100%; color:black;">{{ article.title }}</p>
                  <p class="text-md"><strong>{{ article.published_date }}</strong></p>

                </div>
              </div>
            </div>
          </a>

          <hr>
        </div>
      </div>
    </div>
  </div>

  <!-- <div>
    <div class="news-cards">
      <news-card v-for="(article, index) in articles" :key="index" :article="article"></news-card>
    </div>
  </div> -->
</template>
  
<script>
// import NewsCard from './NYNewsCard.vue';
import NewsService from '../services/NewsService.js';
import NYNavFooter from './NYNavFooter.vue';
export default {

  name: 'NewsList',
  components: {
    // NewsCard,
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
      this.$router.push({ name: 'NYCategories', query: { category: category } });
    },
    fetchNewsData() {
      NewsService.getNews()
        .then((response) => {
          if (response && response.data) {
            // Check if response and response.data are defined
            this.totalResults = response.data.length;
            this.articles = response.data;
            console.log(response.data);
            console.log(this.totalResults);
          } else {
            console.error('Invalid API response:', response);
          }
        })
        .catch((error) => {
          console.log(error);
        })
    },
  },
  computed: {
    firstHalfItems() {
      const totalItems = this.articles.length;
      const middleIndex = Math.floor((10 + totalItems) / 2)+3;
      return this.articles.slice(10, middleIndex);
    },
    secondHalfItems() {
      const totalItems = this.articles.length;
      const middleIndex = Math.floor((10 + totalItems) / 2)+3;
      return this.articles.slice(middleIndex, totalItems);
    },
  },
}
</script>
  
<style scoped>
/* Add styles for category selector and news cards container here
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
} */

.container {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 100vh;
}

.up-div, .down-div {
    height: 50%; 
    padding: 10px; 
}

.custom-link {
  text-decoration: none; /* Remove underline */
  color: white; /* Set text color to white */
  font-family: Georgia, serif;
  font-size:large;
}

</style>
  