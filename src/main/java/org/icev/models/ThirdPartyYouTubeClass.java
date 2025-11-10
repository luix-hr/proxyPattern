package org.icev.models;
import org.icev.interfaces.ThirdPartyYouTubeLib;

import java.util.*;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public List<VideoInfo> listVideos() {
        System.out.println("Calling YouTube API: Listing videos...");
        sleep(1000);

        List<VideoInfo> videos = new ArrayList<>();
        videos.add(new VideoInfo("vid1", "Video One", "Description for Video One"));
        videos.add(new VideoInfo("vid2", "Video Two", "Description for Video Two"));

        return videos;
    }

    @Override
    public VideoInfo getVideoInfo(String id) {
        System.out.println("Calling YouTube API: Getting info for video " + id + "...");
        sleep(500);

        String videoNumber = id.replace("vid", "");
        return new VideoInfo(
                id,
                "Video " + videoNumber,
                "Description for Video " + videoNumber
        );
    }

    @Override
    public void downloadVideo(String id) {
        System.out.println("Calling YouTube API: Downloading video " + id + "...");
        sleep(2000);
        System.out.println("Video " + id + " downloaded.");
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
