<template>
    <h1></h1>
    <div class="news-cards">
        <h1>News Section</h1>
        <div class="item">
            <NYCategoryCard v-for="(article, index) in articles" :key="index" :article="article"></NYCategoryCard>
        </div>
    </div>
</template>
    
<script>
import NewsService from "../services/NewsService"
import NYCategoryCard from "./NYCategoryCard.vue"; // Import the NewsCard component
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
    },
    mounted() {
        console.log("in categories mounted");
        this.fetchNews();
    },
    created() {
        this.category = this.$route.query.category;
        // Use the 'category' variable in your component logic
        console.log(`Category received: ${this.category}`);
    },
    methods: {
        fetchNews() {
            console.log("in categories: ", this.category);
            NewsService.getNewsType(this.category)
                .then((response) => {
                    console.log("in categories: service called");
                    console.log(response);
                    this.articles = response.data;
                    if (this.articles.length > 0) {
                        // console.log(this.articles.at(1).title);
                        console.log(this.articles[0].title);
                        console.log("in categories: articles length > 0");
                    }
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