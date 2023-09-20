<template>
  <div>
    <!-- <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <img src="../public/news_byte.png" alt="Logo" class="logo-image" style="width: 2.5cm; padding-right: 1cm;" />

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#/entertainmentSection">Entertainment</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#" tabindex="-1">Technology</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Health</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#/science">Science</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Sports</a>
            </li>
          </ul>
          <div class="search-section">
            <input type="text" class="search-input" placeholder="Search" style="height: 1cm; border-radius: 0.1cm; background-color: black; color: white; margin-left: 1rem;" />
          </div>
        </div>
      </div>
    </nav> -->
  </div>
  <router-view />
</template>

<script>
export default {
  name: 'App',
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
