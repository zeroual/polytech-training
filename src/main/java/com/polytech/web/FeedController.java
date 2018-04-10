package com.polytech.web;

import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;

import java.util.List;

public class FeedController {

    private PublicationService publicationService = new PublicationService();
    private FeedService feedService = new FeedService();

    public void post(String content) {
        publicationService.share(new Story(content));
    }

    public List<Story> feed() {
        return feedService.fetchAll();
    }
}
