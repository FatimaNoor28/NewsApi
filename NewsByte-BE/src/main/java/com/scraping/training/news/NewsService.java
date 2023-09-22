package com.scraping.training.news;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.print.Doc;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class NewsService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${nyNews.api.key}")
    private String nyApiKey;
    @Value("${nationNews.api.key}")
    private String nation_apiKey;

    public List<NewsArticle> getNewsHeadlines(String category, String language) {
        String apiUrl = "https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json" + "?api-key=" + nyApiKey;

        // Make an HTTP GET request to the News API
        NewsApiResponse response = restTemplate.getForObject(apiUrl, NewsApiResponse.class);
        List<NewsArticle> headlines = new ArrayList<>();
        if (response != null && response.getArticles() != null) {
            for (NewsArticle article : response.getArticles()) {
                NewsArticle newsArticle = getNewsArticle(article);
                headlines.add(newsArticle);
            }
        }

        return headlines;
    }

    private static NewsArticle getNewsArticle(NewsArticle article) {
        List<String> images = new ArrayList<>();
        List<Media> media = article.getMedia();
        String img = "";
        for (Media mediaItem : media) {
            List<MediaMetadata> mediaMetadata = mediaItem.getMetadata();
            img = mediaMetadata.get(1).getUrl();
            System.out.println(img);
        }
        NewsArticle newsArticle = new NewsArticle(article.getTitle() , article.getAbstractText(), article.getPageUrl(), article.getMedia(), images, img);
        return newsArticle;
    }

    public List<Docs> getNews(String category, int page) throws IOException {
        List<Docs> docs = new ArrayList<>();
        String apiUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json?fq=news_desk:(" +category +")&page="+page+"&api-key="+ nyApiKey;
        System.out.println("url api called "+ apiUrl);
        ObjectMapper objectMapper = new ObjectMapper();

        // Read data from the API URL
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(new URL(apiUrl));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        // Extract data from the "docs" array
        JsonNode docsArray = rootNode.path("response").path("docs");
        for (JsonNode doc : docsArray) {
            // Check if "multimedia" is not empty
            if (doc.has("multimedia") && doc.get("multimedia").isArray()) {
                // Extract desired fields
                String abstractText = doc.path("abstract").asText();
                String webUrl = doc.path("web_url").asText();
                String headline = doc.path("headline").path("main").asText();
                JsonNode multimediaArray = doc.path("multimedia");
                String multimediaUrl = "";
                // Iterate over multimedia items
                Iterator<JsonNode> multimediaItems = multimediaArray.elements();
                while (multimediaItems.hasNext()) {
                    JsonNode multimediaItem = multimediaItems.next();
                    multimediaUrl = "https://www.nytimes.com/"+multimediaItem.path("url").asText();

                }
                // Print or use the extracted data as needed
                System.out.println("Abstract: " + abstractText);
                System.out.println("Web URL: " + webUrl);
                System.out.println("Headline: " + headline);
                System.out.println("Multimedia URL: " + multimediaUrl);
                docs.add(new Docs(abstractText,webUrl, headline, multimediaUrl));
            }
        }
        return docs;
    }

    public List<NewsArticle> getNationNewsHeadlines(String country, String language) {
//        &category=sports
//        country=pk&
        String apiUrl = "https://newsdata.io/api/1/news?image=1&domainurl=nation.com.pk&apikey=" + nation_apiKey;

        // Make an HTTP GET request to the News API
        NewsApiResponse response = restTemplate.getForObject(apiUrl, NewsApiResponse.class);
        List<NewsArticle> headlines = new ArrayList<>();
        if (response != null && response.getArticles() != null) {
            for (NewsArticle article : response.getArticles()) {
                NewsArticle newsArticle = new NewsArticle(article.getTitle(), article.getLink(), article.getImage_url());
                headlines.add(newsArticle);
            }
        }

        return headlines;
    }

    public List<NewsArticle> getNationNews(String category) throws InterruptedException {

//        image=1&
            String apiUrl = "https://newsdata.io/api/1/news?domainurl=nation.com.pk&category=" + category + "&apikey=" + nation_apiKey;
            NewsApiResponse response = restTemplate.getForObject(apiUrl, NewsApiResponse.class);
            String nextPage = response.getNextPage();
            List<NewsArticle> headlines = new ArrayList<>();
            if (response != null && response.getArticles() != null) {
                for (NewsArticle article : response.getArticles()) {
                    NewsArticle newsArticle = new NewsArticle(article.getTitle(), article.getLink(), article.getImage_url());
                    headlines.add(newsArticle);
                }
            }
            if(nextPage==null){
                return headlines;
            }
            else{
            apiUrl = "https://newsdata.io/api/1/news?domainurl=nation.com.pk&category=" + category + "&apikey=" + nation_apiKey + "&page=" + nextPage;
        try {
            response = restTemplate.getForObject(apiUrl, NewsApiResponse.class);
            System.out.println("in try");
            if (response != null && response.getArticles() != null) {
                for (NewsArticle article : response.getArticles()) {
                    NewsArticle newsArticle = new NewsArticle(article.getTitle(), article.getLink(), article.getImage_url());
                    headlines.add(newsArticle);
                }
            }
        }catch (HttpClientErrorException.TooManyRequests e) {
            // Handle rate limit exceeded error
            // Extract rate limit headers from e.getResponseHeaders() and wait accordingly
            int retryAfterSeconds = 10;
            Thread.sleep(retryAfterSeconds * 1000);
            System.out.println("in catch");

            response = restTemplate.getForObject(apiUrl, NewsApiResponse.class);
            if (response != null && response.getArticles() != null) {
                for (NewsArticle article : response.getArticles()) {
                    NewsArticle newsArticle = new NewsArticle(article.getTitle(), article.getLink(), article.getImage_url());
                    headlines.add(newsArticle);
                }
            }
        }
            // Retry the request or implement a retry mechanism
        }
        return headlines;
    }

    public List<NewsArticle> getNews(NewsApiResponse response){
        return null;
    }
}
