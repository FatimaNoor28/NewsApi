package com.scraping.training.news;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty; // Import Jackson annotation

public class NewsApiResponse {
    @JsonProperty("results")
    private List<NewsArticle> articles;
    @JsonProperty("nextPage")
    private String nextPage;

    public List<NewsArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsArticle> articles) {
        this.articles = articles;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }
}

