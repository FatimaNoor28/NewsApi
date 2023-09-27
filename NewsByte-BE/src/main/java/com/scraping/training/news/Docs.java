package com.scraping.training.news;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Docs {
    @JsonProperty("abstract")
    private String abstractText;
    @JsonProperty("url")
    private String pageUrl;
    @JsonProperty("title")
    private String title;
    @JsonProperty("image")
    private String imageUrl;

    @JsonProperty("pub_date")
    private String pub_date;
    public Docs(String abstractText, String pageUrl, String title, String imageUrl, String date) {
        this.abstractText = abstractText;
        this.pageUrl = pageUrl;
        this.title = title;
        this.imageUrl = imageUrl;
        this.pub_date = date;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String url) {
        this.pageUrl = url;
    }
}
