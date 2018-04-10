package com.polytech.persistence;

import com.polytech.services.Story;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStoryRepository implements StoryRepository {

    private static List<Story> database = new ArrayList<>();

    public void save(Story content) {
        database.add(content);
    }

    public List<Story> findAll() {
        return database;
    }
}
