package com.scraping.training.news;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class RssFeedEntryService {
    @Autowired
    private RssFeedEntryRepository rssFeedEntryRepository;

    public void fetchAndSaveDataFromRssFeed(String rssFeedUrl) throws IOException, FeedException {
        try {
            URL feedUrl = new URL(rssFeedUrl);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            for (SyndEntry entry : feed.getEntries()) {
                RssFeedEntry rssEntry = new RssFeedEntry();
                rssEntry.setTitle(entry.getTitle());
                System.out.println(entry.getTitle());
                rssEntry.setLink(entry.getLink());
                rssEntry.setDescription(entry.getDescription().getValue());
                System.out.println(entry.getDescription().getValue());
                rssEntry.setPubDate(entry.getPublishedDate());
                System.out.println(entry.getPublishedDate());
                rssFeedEntryRepository.save(rssEntry);
            }
        } catch (IOException | FeedException e) {
            e.printStackTrace();
        }
    }
}
