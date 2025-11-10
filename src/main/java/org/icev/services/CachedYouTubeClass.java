package org.icev.services;
import org.icev.interfaces.ThirdPartyYouTubeLib;
import org.icev.models.VideoInfo;

import java.util.*;

public class CachedYouTubeClass implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib service;
    private Map<String, List<VideoInfo>> listCache;
    private Map<String, VideoInfo> infoCache;

    public CachedYouTubeClass(ThirdPartyYouTubeLib service) {
        this.service = service;
        this.listCache = new HashMap<>();
        this.infoCache = new HashMap<>();
    }

    @Override
    public List<VideoInfo> listVideos() {
        if (listCache.isEmpty()) {
            listCache.put("all", service.listVideos());
        } else {
            System.out.println("Retrieving video list from cache...");
        }
        return listCache.get("all");
    }

    @Override
    public VideoInfo getVideoInfo(String id) {
        if (!infoCache.containsKey(id)) {
            infoCache.put(id, service.getVideoInfo(id));
        } else {
            System.out.println("Retrieving video info for " + id + " from cache...");
        }
        return infoCache.get(id);
    }

    @Override
    public void downloadVideo(String id) {
        service.downloadVideo(id);
    }
}
