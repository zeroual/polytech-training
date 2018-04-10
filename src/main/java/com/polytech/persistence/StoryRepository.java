package com.polytech.persistence;

import com.polytech.services.Story;

import java.util.List;

public interface StoryRepository {


    void save(Story content);

    List<Story> findAll();
}
