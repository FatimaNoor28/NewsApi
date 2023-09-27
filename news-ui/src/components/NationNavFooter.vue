<template>
    <nav class="navbar navbar-expand-lg navbar-light">
       <div class="container-fluid">
  
  
         <a class="navbar-brand" href="#">Navbar</a>
         <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon"></span>
         </button>
         <router-link to="/news/nyTimes">
          <img src="../../public/news_byte.png" alt="Logo" class="logo-image" style="width: 2.5cm; padding-right: 1cm;" />
        </router-link>         <div class="collapse navbar-collapse" id="navbarSupportedContent">
           <ul class="navbar-nav me-auto mb-2 mb-lg-0">
           
            <li class="nav-item"   style="margin-right: 15px;">
                <a class="nav-link active" aria-current="page" href="#" @click="getNews('top')">Headlines</a>
             </li>

             <li class="nav-item"  style="margin-right: 15px;">
                <a class="nav-link active" aria-current="page" href="#" @click="getNews('politics')">Politics</a>
             </li>

              <li class="nav-item"  style="margin-right: 15px;">
                <a class="nav-link active" aria-current="page" href="#" @click="getNews('sports')">Sports</a>
              </li>

              <li class="nav-item"  style="margin-right: 15px;">
                <a class="nav-link active" aria-current="page" href="#" @click="getNews('business')">Business</a>
              </li>
              
              <li class="nav-item"  style="margin-right: 15px;">
                <a class="nav-link active" aria-current="page" href="#" @click="getNews('entertainment')">Entertainment</a>
              </li>
  
           </ul>
          </div>
       </div>
     </nav>
</template>


<script>
export default {
  name: 'NationNavFooter',
  methods: {
    getNews(category) {
      console.log("passing category to Nation Categories page: ", category);
      this.$router.push({ name: 'NationCategories', query: { category: category } });
    },
  }
}
</script>

<style scoped>

.custom-link {
  text-decoration: none; /* Remove underline */
  color: white; /* Set text color to white */
  font-family: Georgia, serif;
  font-size:large;
}
</style>