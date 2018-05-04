package com.polytech.persistence;

import com.polytech.services.Story;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcStoryRepository implements StoryRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcStoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Story story) {
        String query = "INSERT INTO STORY (CONTENT)VALUES(?)";
        jdbcTemplate.update(query, story.getContent());
    }

    public List<Story> findAll() {
        String query = "SELECT * FROM STORY";
        return jdbcTemplate.query(query, new StoryMapper());

    }

    class StoryMapper implements RowMapper<Story> {

        @Override
        public Story mapRow(ResultSet rs, int rowNum) throws SQLException {
            String content = rs.getString("CONTENT");
            return new Story(content);
        }
    }
}
