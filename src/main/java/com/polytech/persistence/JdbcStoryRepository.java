package com.polytech.persistence;

import com.polytech.services.Story;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcStoryRepository implements StoryRepository {


    private Connection connection;


    public JdbcStoryRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Story story) {
        String query = "INSERT INTO STORY (CONTENT)VALUES('" + story.getContent() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Story> findAll() {
        String query = "SELECT * FROM STORY";
        List<Story> stories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String content = resultSet.getString("CONTENT");
                stories.add(new Story(content));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stories;
    }
}
