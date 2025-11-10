package org.icev.models;

public class VideoInfo {
    private String id;
    private String title;
    private String description;

    public VideoInfo(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "VideoInfo{id='" + id + "', title='" + title + "'}";
    }
}
