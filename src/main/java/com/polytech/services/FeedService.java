package com.polytech.services;

import com.polytech.persistence.StoryRepository;

import java.util.List;

public class FeedService {

    private StoryRepository storyRepository = new StoryRepository();

    public List<Story> fetchAll() {
        return storyRepository.findAll();
    }
}
