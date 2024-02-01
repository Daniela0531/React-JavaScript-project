package edu.phystech.inspiration.service;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Episode;
import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.data.User;
import edu.phystech.inspiration.data.repo.StoryRepository;
import edu.phystech.inspiration.service.converters.ChapterConverter;
import edu.phystech.inspiration.service.converters.StoryConverter;
import edu.phystech.inspiration.service.dto.ChapterDto;
import edu.phystech.inspiration.service.dto.StoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryService {

    private final StoryRepository storyRepository;
    private final StoryConverter storyConverter;
    private final ChapterConverter chapterConverter;

    private final ChapterService chapterService;

    public void addStory(StoryDto storyDto) {
        Story story = storyConverter.toEntity(storyDto);
        Story savedStory = storyRepository.save(story);
    }

    public void deleteStory(Long storyId) {
        storyRepository.deleteById(storyId);
    }

    public StoryDto updateStory(Long storyId, StoryDto storyDto) {
        Story existingStory = storyRepository.findById(storyId).orElse(null);
        if (existingStory == null) {
            return null;
        }

        existingStory.setName(storyDto.getName());
        existingStory.setChapters(storyDto.getChapters());

        Story updatedStory = storyRepository.save(existingStory);
        return storyConverter.toDto(updatedStory);
    }

    public StoryDto getStoryById(Long storyId) {
        Story story = storyRepository.findById(storyId).orElse(null);
        return storyConverter.toDto(story);
    }

    public List<ChapterDto> getStoryChapters(StoryDto storyDto) {
        List<Chapter> chapters = storyConverter.toEntity(storyDto).getChapters();
        return chapters.stream()
                .map(chapterConverter::toDto)
                .toList();
    }

    public Boolean isCompleted(StoryDto storyDto) {
        List<Chapter> storyChapters = storyConverter.toEntity(storyDto).getChapters();
        for (Chapter chapter : storyChapters) {
            if (!chapterService.isCompleted(chapterConverter.toDto(chapter))) {
                return false;
            }
        }
        return true;
    }
}
