package com.scraping.training.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.scheduling.annotation.Async;
import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/nyTimes/headlines")
    public List<NewsArticle> getNYNewsHeadlines(@RequestParam(value = "country", required = false, defaultValue = "us") String country,
                                              @RequestParam(value = "category", required = false, defaultValue = "") String category,
                                              @RequestParam(value = "language", required = false, defaultValue = "all") String language) {
        return newsService.getNyTimesNewsHeadlines( category, language);
    }
    @GetMapping("/nyTimes/{category}")
    @Async
    public List<Docs> getNYNews(@PathVariable String category) throws IOException { //@PathVariable int page
        return newsService.getNyTimesNews(category);
    }


    @GetMapping("/nation/headlines")
    public List<NewsArticle> getNationNewsHeadlines(@RequestParam(value = "country", required = false, defaultValue = "pk") String country,
                                                    @RequestParam(value = "language", required = false, defaultValue = "all") String language) throws InterruptedException {
        return newsService.getNationNewsHeadlines(country, language);
    }
    @GetMapping("/nation/{category}")
    @Async
    public List<NewsArticle> getNationNews(@PathVariable String category) throws IOException, InterruptedException {
        return newsService.getNationNews(category);
    }
}

