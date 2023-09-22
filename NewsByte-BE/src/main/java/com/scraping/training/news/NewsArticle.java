package com.scraping.training.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NewsArticle {

    private String title;
    @JsonProperty("link")
    private String link;
    @JsonProperty("image_url")
    private String image_url;


    @JsonProperty("abstract")
    private String abstractText;
    @JsonProperty("url")
    private String pageUrl;

    //private List<String> imageUrl;
    String image;
    @JsonProperty("media")
    private List<Media> media;
    public NewsArticle() {}
    public NewsArticle(String title, String abstractText, String pageUrl, List<Media> media, List<String> imageUrl, String img) {
        this.title = title;
        this.abstractText = abstractText;
        this.pageUrl = pageUrl;
        this.image = img;
    }
    public NewsArticle(String title, String link, String image_url) {
        this.title = title;
        this.link = link;
        this.image_url = image_url;
    }
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

//    public List<String> getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl.add(imageUrl);
//    }
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
