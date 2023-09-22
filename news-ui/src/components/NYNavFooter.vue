<template>
<div>
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <router-link to="/news/nyTimes">
          <img src="../../public/news_byte.png" alt="Logo" class="logo-image" style="width: 2.5cm; padding-right: 1cm;" />
        </router-link>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#" @click="getNews('fashion')">Entertainment</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#" tabindex="-1" @click="getNews('technology')">Technology</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" @click="getNews('health')">Health</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" @click="getNews('science')">Science</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" @click="getNews('sports')">Sports</a>
            </li>
          </ul>
          <div class="search-section">
            <input type="text" class="search-input" placeholder="Search"
              style="height: 1cm; border-radius: 0.1cm; background-color: black; color: white; margin-left: 1rem;" />
          </div>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'NYNavFooter',
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