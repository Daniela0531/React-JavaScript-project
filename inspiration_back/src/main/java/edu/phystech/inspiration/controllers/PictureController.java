package edu.phystech.inspiration.controllers;

import edu.phystech.inspiration.data.Episode;
import edu.phystech.inspiration.service.EpisodeService;
import edu.phystech.inspiration.service.PictureService;
import edu.phystech.inspiration.service.converters.EpisodeConverter;
import edu.phystech.inspiration.service.dto.PictureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor
public class PictureController {
    private final PictureService pictureService;
    private final EpisodeService episodeService;
    private final EpisodeConverter episodeConverter;

    @PostMapping("/add/{episodeId}/{imageURI}")
    public void addPicture(@PathVariable Long episodeId, @PathVariable String imageURI) {
        Episode episode = episodeConverter.toEntity(episodeService.getEpisodeById(episodeId));
        if (episode == null) {
            return;
        }
        List<Episode> episodes = new ArrayList<>();
        episodes.add(episode);
        pictureService.addPicture(new PictureDto(episodes, imageURI));
    }

    @PostMapping("/delete/{id}")
    public void deletePictureById(@PathVariable Long id) {
        PictureDto pictureDto = pictureService.getPicture(id);
        if (pictureDto == null) {
            return;
        }
        pictureService.deletePicture(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PictureDto> getPicture(@PathVariable Long id) {
        PictureDto pictureDto = pictureService.getPicture(id);
        return ResponseEntity.ok(pictureDto);
    }

    @PostMapping("/update/{id}/{episodeId}/add-episode")
    public void addEpisodeToList(@PathVariable Long id, @PathVariable Long episodeId) {
        pictureService.addEpisodeToList(id, episodeId);
    }

    @PostMapping("/update/{id}/{episodeId}/delete-episode")
    public void deleteEpisodeFromList(@PathVariable Long id, @PathVariable Long episodeId) {
        pictureService.deleteEpisodeFromList(id, episodeId);
    }

}
