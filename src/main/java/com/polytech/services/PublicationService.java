package com.polytech.services;

import com.polytech.persistence.StoryRepository;


public class PublicationService {

    private StoryRepository storyRepository = new StoryRepository();

    public void share(Story content) {
        storyRepository.save(content);
    }
}
