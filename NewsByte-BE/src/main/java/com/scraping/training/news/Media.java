package com.scraping.training.news;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Media {
    @JsonProperty("media-metadata")
    private List<MediaMetadata> metadata;

    public void setMetadata(List<MediaMetadata> metadata) {
        this.metadata = metadata;
    }

    public List<MediaMetadata> getMetadata() {
        return metadata;
    }
}
