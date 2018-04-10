package com.polytech.services;

import java.util.Objects;

public class Story {
    private String content;

    public Story(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(content, story.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(content);
    }

    public String getContent() {
        return content;
    }
}
