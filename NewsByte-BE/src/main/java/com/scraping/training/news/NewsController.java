package com.scraping.training.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/headlines")
    public List<NewsArticle> getNewsHeadlines(@RequestParam(value = "country", required = false, defaultValue = "us") String country,
                                              @RequestParam(value = "category", required = false, defaultValue = "") String category,
                                              @RequestParam(value = "language", required = false, defaultValue = "all") String language) {
        return newsService.getNewsHeadlines( category, language);
    }

    @GetMapping("/{category}")
    public List<Docs> getHealthNews(@RequestParam(value = "category", required = false, defaultValue = "") String category,
                                           @RequestParam(value = "language", required = false, defaultValue = "all") String language) throws IOException {
        return newsService.getNews(category);
    }
}

