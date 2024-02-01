package edu.phystech.inspiration.service.converters;

import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.service.dto.StoryDto;
import org.springframework.stereotype.Component;

@Component
public class StoryConverter {
    public StoryDto toDto(Story story) {
        StoryDto storyDto = new StoryDto();
        storyDto.setUser(story.getUser());
        storyDto.setName(story.getName());
        return storyDto;
    }

    public Story toEntity(StoryDto storyDto) {
        Story story = new Story();
        story.setUser(storyDto.getUser());
        story.setName(storyDto.getName());
        return story;
    }
}
