package com.scraping.training.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class NewsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${news.api.key}")
    private String apiKey;

    public List<NewsArticle> getNewsHeadlines(String country, String category, String language) {
        String apiUrl = "https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=" + apiKey;

        // Make an HTTP GET request to the News API
        NewsApiResponse response = restTemplate.getForObject(apiUrl, NewsApiResponse.class);
//        System.out.println(response);

        // Extract and return headlines from the response
        List<NewsArticle> headlines = new ArrayList<>();
        if (response != null && response.getArticles() != null) {
            for (NewsArticle article : response.getArticles()) {
                System.out.println(article.getMedia());
                System.out.println(article.getPageUrl());
                NewsArticle newsArticle = new NewsArticle(article.getTitle() , article.getAbstractText(), article.getPageUrl(), article.getImageUrl());
                headlines.add(newsArticle);
            }
        }

        return headlines;
    }
}
