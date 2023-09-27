package com.scraping.training.news;

import com.rometools.rome.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/rss")
public class RssFeedController {
    @Autowired
    private RssFeedEntryRepository rssFeedEntryRepository;
    @Autowired
    private RssFeedEntryService service;
    @GetMapping("/entries")
    public List<RssFeedEntry> getAllRssEntries() throws FeedException, IOException {
        service.fetchAndSaveDataFromRssFeed("https://rss.app/feeds/T46MCNPSSphWj6xr.xml");
        return rssFeedEntryRepository.findAll();
    }
}
