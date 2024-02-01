package edu.phystech.inspiration.service;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Episode;
import edu.phystech.inspiration.data.Picture;
import edu.phystech.inspiration.data.repo.EpisodeRepository;
import edu.phystech.inspiration.data.repo.PictureRepository;
import edu.phystech.inspiration.service.converters.EpisodeConverter;
import edu.phystech.inspiration.service.converters.PictureConvecter;
import edu.phystech.inspiration.service.dto.PictureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PictureService {
    private final PictureConvecter pictureConvecter;
    private final PictureRepository pictureRepository;

    private final EpisodeConverter episodeConverter;

    private final EpisodeRepository episodeRepository;

    public void addPicture(PictureDto pictureDto) {
        Picture picture = pictureConvecter.toEntity(pictureDto);
        Picture savedPicture = pictureRepository.save(picture);
    }

    public void deletePicture(Long id) {
        pictureRepository.deleteById(id);
    }

    public void addEpisodeToList(Long id, Long episodeId) {
        Picture picture = pictureRepository.findById(id).orElse(null);
        if (picture == null) {
            return;
        }
        Episode episode = episodeRepository.findById(episodeId).orElse(null);
        if (episode == null) {
            return;
        }
        picture.getEpisodes().add(episode);
    }

    public void deleteEpisodeFromList(Long id, Long episodeId) {
        Picture picture = pictureRepository.findById(id).orElse(null);
        if (picture == null) {
            return;
        }
        Episode episode = episodeRepository.findById(episodeId).orElse(null);
        if (episode == null) {
            return;
        }
        picture.getEpisodes().remove(episode);
    }

    public PictureDto getPicture(Long id) {
        Picture picture = pictureRepository.findById(id).orElse(null);
        if (picture == null) {
            return null;
        }
        return pictureConvecter.toDto(picture);
    }
}
