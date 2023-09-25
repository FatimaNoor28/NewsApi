<template>
    <!-- <NavFooter92/> -->
    <div>
    <NationNavFooter />
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
        <div v-if="newsItems.length > 0" class="top-div row">

            <div class="left-top-div col-6" style="max-height: 90%;">
                <a :href="newsItems[0].link" style="text-decoration: none;">
                    <div class="card text-center" style="border: none;">
                        <img class="card-img-top" :src="newsItems[0].image_url" alt="Card image cap" style="max-height: 50%;">
                        <div class="card-body" >
                            <p class="text-md">{{ newsItems[0].title }}</p>
                            <p class="text-sm"><strong>{{ newsItems[0].pubDate }}</strong></p>
                        </div>
                    </div>
                </a>
                
            </div>

            <div class="mid-top-div col-3">
                <div class="up-div" style="max-height: 45%; overflow: hidden;">
                    <a :href="newsItems[1].link" style="text-decoration: none;">
                        <div class="card text-center"  style="border: none;">
                            <img class="card-img-top img-fluid" :src="newsItems[1].image_url" alt="Card image cap">
                            <div class="card-body"  :class="{ 'hovered': isHovered }">
                                <p class="text-md">{{ newsItems[1].title }}</p>
                                <p class="text-md"><strong>{{ newsItems[1].pubDate }}</strong></p>
                            </div>
                        </div>
                    </a>
                    
                </div>

                <div class="down-div" style="max-height: 45%; overflow: hidden;">
                    <a :href="newsItems[2].link" style="text-decoration: none;">
                        <div class="card text-center"  style="border: none;">
                            <img class="card-img-top img-fluid" :src="newsItems[2].image_url" alt="Card image cap">
                            <div class="card-body">
                                <p class="text-md">{{ newsItems[2].title }}</p>
                                <p class="text-md"><strong>{{ newsItems[2].pubDate }}</strong></p>
                            </div>
                        </div>
                    </a>
                    
                </div>
            </div>

            <div class="right-top-div col-3">
                <div class="up-div" style="max-height: 45%; overflow: hidden;">
                    <a :href="newsItems[3].link" style="text-decoration: none;">
                        <div class="card text-center"  style="border: none;" >
                            <img class="card-img-top" :src="newsItems[3].image_url" alt="Card image cap">
                            <div class="card-body"  :class="{ 'hovered': isHovered }">
                                <p class="text-md">{{ newsItems[3].title }}</p>
                                <p class="text-md"><strong>{{ newsItems[3].pubDate }}</strong></p>
                            </div>
                        </div>
                    </a>
                    
                </div>

                <div class="down-div" style="max-height: 45%; overflow: hidden;">
                    <a :href="newsItems[4].link" style="text-decoration: none;">
                        <div class="card text-center"  style="border: none;">
                            <img class="card-img-top" :src="newsItems[4].image_url" alt="Card image cap">
                            <div class="card-body"  :class="{ 'hovered': isHovered }">
                                <p class="text-md">{{ newsItems[4].title }}</p>
                                <p class="text-md"><strong>{{ newsItems[4].pubDate }}</strong></p>
                            </div>
                        </div>
                    </a>
                    
                </div>
            </div>
        </div>


                                                                                                                    <!-- THIS IS MIDDLE DIV -->

        <hr style="border: 1px solid #000;">
        <div v-if="newsItems.length >= 8" class="middle-div d-flex align-items-stretch row" style="margin-top: 30px;">
            <div v-for="(item, index) in newsItems.slice(5, 9)" :key="index" class="left-div-middle col-sm-3">
                <a :href="item.link" style="text-decoration: none;">
                    <div class="card text-center"  style="border: none;">
                        <img class="card-img-top" :src="item.image_url" alt="Card image cap" style="max-height: 50%;">
                        <div class="card-body" >
                            <p class="text-md">{{ item.title }}</p>
                            <p class="text-md"><strong>{{ item.pubDate }}</strong></p>
                        </div>
                    </div>
                </a>
            </div>
        </div>


                                                                                                                    <!-- THIS IS BOTTOM DIV -->


        <div v-if="newsItems.length >=9" class="bottom-div" style="margin-top: 10px; margin-bottom: 20px;">
            <div class="card text-center"  style="border: none;">
                    <img class="card-img-top" :src="newsItems[9].image_url" alt="Card image cap" style="max-height: 300px;">
                    <div class="card-body">
                        <p class="text-md">{{ newsItems[9].title }}</p>
                        <p class="text-md"><strong>{{ newsItems[9].pubDate }}</strong></p>
                    </div>
                </div>
                
        </div>
                                                                                                                    <!-- THIS IS last DIV -->
         
        <br><br> 
        <hr style="border: 1px solid #000;">                                                                                                    
        <div class="last-div row" style="margin-top: 20px;">
            <div class="last-div-left col-5">
                <div v-for="(item, index) in firstHalfItems" :key="index">
                    <a :href="item.link" style="text-decoration: none;">
                        <h6 style="color:black;">{{ item.title }}</h6>
                        <p class="text-md"><strong>{{ item.pubDate }}</strong></p>
                    </a>
                    
                    <hr>
                </div>
            </div> 


            <div class="last-div-right col-5"  style="margin-left: 40px; border-left: 1px solid #000;">
                <div v-for="(item, index) in secondHalfItems" :key="index">
                    <a :href="item.link" style="text-decoration: none;">
                        <div class="row" style="max-height: 200px; margin-top: 10px;">
                            <div class="col-5">
                                <div>
                                    <img :src="item.image_url" alt="Card image cap" style="max-width: 90%; max-height: 100%;">
                                </div>
                            </div>
                            <div class="col-5">
                                <div>
                                    <p style="max-width: 90%; max-height: 100%; color:black;">{{ item.title }}</p> 
                                    <p class="text-md"><strong>{{ item.pubDate }}</strong></p>
                                </div>
                            </div>
                        </div>
                    </a>
                    
                    <hr>
                </div>
            </div>
        </div>
    </div>

</template>
<script>
import NewsService from "../services/NewsService";

import NationNavFooter from "./NationNavFooter.vue";

export default {
  name: "NationTopList",
  data() {
    return {
      newsItems: [],
    };
  },
  components: {
    NationNavFooter
},created(){
    this.getNationNews();
  },

  mounted(){
    this.getNationNews();
  },
  methods: {
    getNationNews() {
      NewsService.getNationNews()
        .then((response) => {
          console.log(response);
          this.newsItems = response.data;
        })
        .catch((error) => {
          console.error("Error fetching data in home:", error);
        });
    },
   

    },
  
  computed: {
    firstHalfItems() {
      const totalItems = this.newsItems.length;
      const middleIndex = Math.floor((10 + totalItems) / 2)+3;
      return this.newsItems.slice(10, middleIndex);
    },
    secondHalfItems() {
      const totalItems = this.newsItems.length;
      const middleIndex = Math.floor((10 + totalItems) / 2)+3;
      return this.newsItems.slice(middleIndex, totalItems);
    },
  },
};
</script>
<style>
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