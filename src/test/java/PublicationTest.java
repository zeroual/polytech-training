package com;

import com.polytech.persistence.StoryRepository;
import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;
import com.polytech.web.FeedController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PublicationTest {


    private FeedController feedController;

    @Before
    public void setUp(){
        StoryRepository storyRepository = new StoryRepository();
        PublicationService publicationService = new PublicationService(storyRepository);
        FeedService feedService = new FeedService(storyRepository);
        feedController = new FeedController(publicationService, feedService);

    }
    @Test
    public void should_post_story() {

        //GIVEN
        String story = "hi Info4";

        //WHEN
        feedController.post(story);

        //THEN

        List<Story> postedStories = feedController.feed();
        Assert.assertEquals(Arrays.asList(new Story("hi Info4")), postedStories);

    }
}
