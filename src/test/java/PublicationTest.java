
import com.polytech.config.AppConfig;
import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class PublicationTest {


    private PublicationService publicationService;
    private FeedService feedService;


    @Before
    public void setUp() {
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        publicationService = container.getBean(PublicationService.class);
        feedService = container.getBean(FeedService.class);


    }

    @Test
    @Ignore
    public void should_post_story() {

        //GIVEN
        String story = "hi Info4";

        //WHEN
        publicationService.share(new Story(story));

        //THEN

        List<Story> postedStories = feedService.fetchAll();
        Assert.assertEquals(Arrays.asList(new Story("hi Info4")), postedStories);

    }
}
