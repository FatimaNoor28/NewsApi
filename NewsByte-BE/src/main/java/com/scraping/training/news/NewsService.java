package com.scraping.training.news;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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

    @Value("${news.api.key}")
    private String apiKey;

    public List<NewsArticle> getNewsHeadlines(String category, String language) {
        String apiUrl = "https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json" + "?api-key=" + apiKey;

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
//            if (mediaMetadata != null && !mediaMetadata.isEmpty()) {
//                for (MediaMetadata metadata : mediaMetadata) {
//                    images.add(metadata.getUrl());
//                }
//            }
        }
        NewsArticle newsArticle = new NewsArticle(article.getTitle() , article.getAbstractText(), article.getPageUrl(), article.getMedia(), images, img);
        return newsArticle;
    }
//    public List<Docs> getNewsCategory(String category, String language) {
//        String apiUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json" + "?fq="+ category +"&api-key="+ apiKey;
//        System.out.println("url api called");
//        // Make an HTTP GET request to the News API
//        NewsApiCategory response = restTemplate.getForObject(apiUrl, NewsApiCategory.class);
//        System.out.println("got response "+ response);
//        List<NewsCategory> newsCategories = response.getResponse();
//        if (newsCategories != null && response.getResponse() != null) {
//            for (NewsCategory newsCategory : response.getResponse()) {
//
//            }
//        }
//        List<Docs> docs = newsCategories.get(1).getDocs();
//        if (response != null && response.getResponse() != null) {
//            for (NewsCategory newsCategory : response.getResponse()) {
//                System.out.println(newsCategory);
//                Docs doc = getNewsArticle(newsCategory);
//                news.add(doc);
//            }
//        }
//
//        return news;
//    }

    public List<Docs> getNews(String category) throws IOException {
        List<Docs> docs = new ArrayList<>();
        String apiUrl = "https://api.nytimes.com/svc/search/v2/articlesearch.json" + "?fq="+ category +"&api-key="+ apiKey;
//        System.out.println("url api called");
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
                    multimediaUrl = multimediaItem.path("url").asText();

                    // Print or use the extracted data as needed
                    System.out.println("Abstract: " + abstractText);
                    System.out.println("Web URL: " + webUrl);
                    System.out.println("Headline: " + headline);
                    System.out.println("Multimedia URL: " + multimediaUrl);


                }
                docs.add(new Docs(abstractText,webUrl, headline, multimediaUrl));
            }
        }
        return docs;
    }
}
