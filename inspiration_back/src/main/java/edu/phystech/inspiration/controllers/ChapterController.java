package edu.phystech.inspiration.controllers;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Episode;
import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.service.ChapterService;
import edu.phystech.inspiration.service.EpisodeService;
import edu.phystech.inspiration.service.PictureService;
import edu.phystech.inspiration.service.StoryService;
import edu.phystech.inspiration.service.converters.ChapterConverter;
import edu.phystech.inspiration.service.converters.EpisodeConverter;
import edu.phystech.inspiration.service.converters.StoryConverter;
import edu.phystech.inspiration.service.dto.ChapterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/chapters")
@RequiredArgsConstructor
public class ChapterController {
    private final ChapterService chapterService;
    private final ChapterConverter chapterConvecter;
    private final PictureService pictureService;
    private final StoryConverter storyConverter;
    private final StoryService storyService;

    private final EpisodeService episodeService;
    private final EpisodeConverter episodeConverter;

    @PostMapping("/add/{storyId}/{num}")
    public void addChapter(@PathVariable Long storyId, @PathVariable Long num) {
        Story story = storyConverter.toEntity(storyService.getStoryById(storyId));
        if (story == null) {
            return;
        }
        chapterService.addChapter(new ChapterDto(story, num, new ArrayList<>()));
    }

    @PostMapping("/delete/{id}")
    public void deleteChapter(@PathVariable Long id) {
        ChapterDto chapterDto = chapterService.getChapterById(id);
        if (chapterDto == null) {
            return;
        }
        chapterService.deleteChapter(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapterDto> getChapter(@PathVariable Long id) {
        ChapterDto chapterDto = chapterService.getChapterById(id);
        return ResponseEntity.ok(chapterDto);
    }

    @PostMapping("/update/{id}/num/{num}")
    public void updateNum(@PathVariable Long id, @PathVariable Long num) {
        chapterService.getChapterById(id).setNum(num);
    }

    @PostMapping("/update/{id}/add-episode/{episodeId}")
    public void addEpisode(@PathVariable Long id, @PathVariable Long episodeId) {
        Episode episode = episodeConverter.toEntity(episodeService.getEpisodeById(episodeId));
        if (episode == null) {
            return;
        }
        Chapter chapter = chapterConvecter.toEntity(chapterService.getChapterById(id));
        if (chapter == null) {
            return;
        }
        chapter.getEpisodes().add(episode);
    }

    @PostMapping("/update/{id}/delete-episode/{episodeId}")
    public void deleteEpisode(@PathVariable Long id, @PathVariable Long episodeId) {
        Episode episode = episodeConverter.toEntity(episodeService.getEpisodeById(episodeId));
        if (episode == null) {
            return;
        }
        chapterService.getChapterById(id).getEpisodes().remove(episode);
    }

    @PostMapping("/update/{id}/storyId/{storyId}")
    public void updateStatus(@PathVariable Long id, @PathVariable Long storyId) {
        Story story = storyConverter.toEntity(storyService.getStoryById(storyId));
        if (story == null) {
            return;
        }
        chapterService.getChapterById(id).setStoryId(story);
    }
}
