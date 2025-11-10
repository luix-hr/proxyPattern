package org.icev;

import org.icev.client.YouTubeManager;
import org.icev.interfaces.ThirdPartyYouTubeLib;
import org.icev.models.ThirdPartyYouTubeClass;
import org.icev.services.CachedYouTubeClass;

public class Main {
    public static void main(String[] args) {
        ThirdPartyYouTubeLib realService = new ThirdPartyYouTubeClass();
        ThirdPartyYouTubeLib proxyService = new CachedYouTubeClass(realService);

        System.out.println("--- First run with Proxy (populates cache) ---");
        YouTubeManager manager = new YouTubeManager(proxyService);
        manager.renderListPanel();
        manager.renderVideoPage("vid1");
        manager.renderVideoPage("vid2");
        manager.service.downloadVideo("vid1");

        System.out.println("\n--- Second run with Proxy (uses cache) ---");
        manager.renderListPanel();
        manager.renderVideoPage("vid1");
        manager.renderVideoPage("vid3");
    }
}