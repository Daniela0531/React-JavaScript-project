package edu.phystech.inspiration.controllers;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.data.User;
import edu.phystech.inspiration.service.*;
import edu.phystech.inspiration.service.converters.ChapterConverter;
import edu.phystech.inspiration.service.converters.StoryConverter;
import edu.phystech.inspiration.service.converters.UserConverter;
import edu.phystech.inspiration.service.dto.StoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/stories")
@RequiredArgsConstructor
public class StoryController {
    private final StoryService storyService;
    private final StoryConverter storyConverter;
    private final UserConverter userConverter;
    private final UserService userService;

    private final ChapterService chapterService;
    private final ChapterConverter chapterConverter;

    @PostMapping("/add/{userId}/{name}")
    public void addStory(@PathVariable Long userId, @PathVariable String name) {
        User user = userConverter.toEntity(userService.getUserById(userId));
        if (user == null) {
            return;
        }
        storyService.addStory(new StoryDto(new ArrayList<>(), user, name));
    }

    @PostMapping("/delete/{id}")
    public void deleteStory(@PathVariable Long id) {
        StoryDto storyDto = storyService.getStoryById(id);
        if (storyDto == null) {
            return;
        }
        storyService.deleteStory(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoryDto> getStory(@PathVariable Long id) {
        StoryDto storyDto = storyService.getStoryById(id);
        return ResponseEntity.ok(storyDto);
    }

    @PostMapping("/update/{id}/name/{name}")
    public void updateName(@PathVariable Long id, @PathVariable String name) {
        storyService.getStoryById(id).setName(name);
    }

    @PostMapping("/update/{id}/add-chapter/{chapterId}")
    public void addChapter(@PathVariable Long id, @PathVariable Long chapterId) {
        Chapter chapter = chapterConverter.toEntity(chapterService.getChapterById(chapterId));
        if (chapter == null) {
            return;
        }
        Story story = storyConverter.toEntity(storyService.getStoryById(id));
        if (story == null) {
            return;
        }
        story.getChapters().add(chapter);
    }

    @PostMapping("/update/{id}/delete-chapter/{chapterId}")
    public void deleteChapter(@PathVariable Long id, @PathVariable Long chapterId) {
        Chapter chapter = chapterConverter.toEntity(chapterService.getChapterById(chapterId));
        if (chapter == null) {
            return;
        }
        storyService.getStoryById(id).getChapters().remove(chapter);
    }
}
