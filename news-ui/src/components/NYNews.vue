<!-- <template>

  <div>
    <NYNavFooter />
  </div>
  <div>
    <NewsList />
  </div>
</template>
  
<script>
import NewsList from './NYNewsList.vue';
import NYNavFooter from './NYNavFooter.vue';
export default {
  components: {
    NewsList,
    NYNavFooter,
  },
  name: 'NY-News',
  methods: {
    // openArticle(url) {
    //   console.log("clicked on article");
    //   window.open(url);
    // },
    getNews(category) {
      // Toggle the balance view
      // NewsService.getHealthNews("health")
      console.log("passing category to NY Categories page: ", category);
      this.$router.push({ name: 'NYCategories', query: { category: category } });
    },
  }
}
</script>
  
<style lang="scss" scoped>
.container {
  position: relative;

  .searchbar {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    width: 100%;
    height: 60px;
    font-size: 1.6rem;

    input {
      padding: 0 100px 0 20px;
      margin: 0;
      width: calc(100% - 120px);
      height: 60px;
      border: none;
      font-size: 2rem;
      color: #fff;
      background-color: #222;

      &:focus {
        outline: none;
      }
    }

    .search-icons {
      position: absolute;
      right: 20px;
      top: 20px;
      color: #fff;

      i {
        margin-left: 15px;
        cursor: pointer;
      }
    }
  }

  .result-list {
    padding-top: 60px;
  }

  article {
    display: grid;
    grid-template-columns: 200px auto 40px;
    grid-template-rows: 100px;
    border-bottom: 1px solid #ccc;
    overflow: hidden;
    cursor: pointer;

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

    section {
      margin: 0;
      padding: 10px;
      height: 100px;
    }

    footer {
      display: flex;
      justify-content: center;
      align-items: center;
      font-size: 1.6rem;
      color: #888;
    }
  }

  #scroll-trigger {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100px;
    font-size: 1.6rem;
  }
}
</style> -->