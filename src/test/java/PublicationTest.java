
import com.polytech.config.AppConfig;
import com.polytech.services.Story;
import com.polytech.web.FeedController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class PublicationTest {


    private FeedController feedController;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        feedController = container.getBean(FeedController.class);

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
