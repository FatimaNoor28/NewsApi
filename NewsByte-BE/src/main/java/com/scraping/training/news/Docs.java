package com.scraping.training.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class Docs {
    @JsonProperty("abstract")
    private String abstractText;
    @JsonProperty("url")
    private String pageUrl;
    @JsonProperty("title")
    private String title;
    @JsonProperty("image")
    private String imageUrl;
    public Docs(String abstractText, String pageUrl, String title, String imageUrl) {
        this.abstractText = abstractText;
        this.pageUrl = pageUrl;
        this.title = title;
        this.imageUrl = imageUrl;
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
