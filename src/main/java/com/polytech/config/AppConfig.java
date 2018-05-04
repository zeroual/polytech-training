package com.polytech.config;

import com.polytech.persistence.JdbcStoryRepository;
import com.polytech.persistence.StoryRepository;
import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.web.FeedController;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {


    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public StoryRepository storyRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcStoryRepository(jdbcTemplate);
    }

    @Bean
    public FeedService
    feedService(StoryRepository storyRepository) {
        return new FeedService(storyRepository);
    }

    @Bean
    public PublicationService publicationService(StoryRepository storyRepository) {
        return new PublicationService(storyRepository);
    }

    @Bean
    public FeedController feedController(PublicationService publicationService, FeedService feedService) {
        return new FeedController(publicationService, feedService);
    }


    @Bean
    public DataSource dataSource() {
        //  return new EmbeddedDatabaseBuilder()
        //        .build();
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "root";

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
