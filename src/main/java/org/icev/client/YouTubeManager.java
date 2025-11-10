package org.icev.client;
import org.icev.interfaces.ThirdPartyYouTubeLib;
import org.icev.models.VideoInfo;

import java.util.*;

public class YouTubeManager {
    public ThirdPartyYouTubeLib service;

    public YouTubeManager(ThirdPartyYouTubeLib service) {
        this.service = service;
    }

    public void renderVideoPage(String videoId) {
        VideoInfo info = service.getVideoInfo(videoId);
        System.out.println("Rendering video page for " + info.getTitle());
    }

    public void renderListPanel() {
        List<VideoInfo> list = service.listVideos();
        System.out.println("Rendering list panel with " + list.size() + " videos.");
    }

}