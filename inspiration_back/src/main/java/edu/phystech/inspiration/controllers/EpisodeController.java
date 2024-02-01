package edu.phystech.inspiration.controllers;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Picture;
import edu.phystech.inspiration.service.*;
import edu.phystech.inspiration.service.converters.*;
import edu.phystech.inspiration.service.dto.EpisodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor
public class EpisodeController {
    private final EpisodeService episodeService;
    private final ChapterService chapterService;
    private final ChapterConverter chapterConverter;

    private final PictureConvecter pictureConvecter;

    private final PictureService pictureService;

    @PostMapping("/add/{chapterId}/{num}")
    public void addEpisode(@PathVariable Long chapterId, @PathVariable Long num) {
        Chapter chapter = chapterConverter.toEntity(chapterService.getChapterById(chapterId));
        if (chapter == null) {
            return;
        }
        episodeService.addEpisode(new EpisodeDto(null, num, false, null, chapter));
    }

    @PostMapping("/delete/{id}")
    public void deleteEpisode(@PathVariable Long id) {
        EpisodeDto episodeDto = episodeService.getEpisodeById(id);
        if (episodeDto == null) {
            return;
        }
        episodeService.deleteEpisode(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpisodeDto> getEpisodeById(@PathVariable Long id) {
        EpisodeDto episodeDto = episodeService.getEpisodeById(id);
        return ResponseEntity.ok(episodeDto);
    }

    @PostMapping("/update/{id}/text")
    public void updateText(@PathVariable Long id, @RequestBody String text) {
        episodeService.getEpisodeById(id).setText(text);
    }

    @PostMapping("/update/{id}/add-picture/{pictureId}")
    public void addPicture(@PathVariable Long id, @PathVariable Long pictureId) {
        Picture picture = pictureConvecter.toEntity(pictureService.getPicture(pictureId));
        if (picture == null) {
            return;
        }
        episodeService.getEpisodeById(id).setIdPicture(picture);
    }

    @PostMapping("/update/{id}/delete-picture")
    public void deletePicture(@PathVariable Long id) {
        episodeService.getEpisodeById(id).setIdPicture(null);
    }

    @PostMapping("/update/{id}/status/{status}")
    public void updateStatus(@PathVariable Long id, @PathVariable Boolean status) {
        episodeService.getEpisodeById(id).setIsComplete(status);
    }

    @PostMapping("/update/{id}/num/{num}")
    public void updateNum(@PathVariable Long id, @PathVariable Long num) {
        episodeService.getEpisodeById(id).setNum(num);
    }
}
