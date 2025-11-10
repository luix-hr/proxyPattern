package org.icev.interfaces;
import org.icev.models.VideoInfo;

import java.util.List;

public interface ThirdPartyYouTubeLib {
    List<VideoInfo> listVideos();
    VideoInfo getVideoInfo(String id);
    void downloadVideo(String id);
}