package com;

import com.polytech.services.Story;
import com.polytech.web.FeedController;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PublicationTest {

    @Test
    public void should_post_story() {

        //GIVEN
        String story = "hi Info4";
        FeedController feedController = new FeedController();

        //WHEN
        feedController.post(story);

        //THEN

        List<Story> postedStories = feedController.feed();
        Assert.assertEquals(Arrays.asList(new Story("hi Info4")), postedStories);

    }
}
