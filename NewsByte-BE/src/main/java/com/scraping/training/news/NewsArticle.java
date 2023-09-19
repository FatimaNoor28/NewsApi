package com.scraping.training.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NewsArticle {

    private String title;
    @JsonProperty("abstract")
    private String abstractText;
    @JsonProperty("url")
    private String pageUrl;
    private List<String> imageUrl;
    @JsonProperty("media")
    private List<Media> media;
    public NewsArticle() {}
    public NewsArticle(String title, String abstractText, String pageUrl, List<Media> media, List<String> imageUrl) {
        this.title = title;
        this.abstractText = abstractText;
        this.pageUrl = pageUrl;
        this.media = media;
        this.imageUrl = imageUrl;
    }
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl.add(imageUrl);
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }
    public void setMedia(List<Media> Media) {
        this.media = Media;
    }
    public List<Media> getMedia() {
        return media;
    }
}
