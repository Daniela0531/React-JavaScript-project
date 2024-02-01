package edu.phystech.inspiration.service;

import edu.phystech.inspiration.data.*;
import edu.phystech.inspiration.data.Episode;
import edu.phystech.inspiration.data.repo.EpisodeRepository;
import edu.phystech.inspiration.service.converters.ChapterConverter;
import edu.phystech.inspiration.service.converters.EpisodeConverter;
import edu.phystech.inspiration.service.converters.EpisodeConverter;
import edu.phystech.inspiration.service.dto.ChapterDto;
import edu.phystech.inspiration.service.dto.EpisodeDto;
import edu.phystech.inspiration.service.dto.EpisodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final EpisodeConverter episodeConverter;
    private final ChapterConverter chapterConverter;

    public EpisodeDto addEpisode(EpisodeDto episodeDto) {
        Episode episode = episodeConverter.toEntity(episodeDto);
        Episode savedEpisode = episodeRepository.save(episode);
        return episodeConverter.toDto(savedEpisode);
    }

    public void deleteEpisode(Long episodeId) {
        episodeRepository.deleteById(episodeId);
    }

    public EpisodeDto updateEpisode(Long episodeId, EpisodeDto episodeDto) {
        Episode existingEpisode = episodeRepository.findById(episodeId).orElse(null);
        if (existingEpisode == null) {
            return null;
        }

        existingEpisode.setIdPicture(episodeDto.getIdPicture());
        existingEpisode.setNum(episodeDto.getNum());
        existingEpisode.setIsComplete(episodeDto.getIsComplete());
        existingEpisode.setText(episodeDto.getText());
        existingEpisode.setChapter(episodeDto.getChapter());

        Episode updatedEpisode = episodeRepository.save(existingEpisode);
        return episodeConverter.toDto(updatedEpisode);
    }

    public EpisodeDto getEpisodeById(Long episodeId) {
        Episode episode = episodeRepository.findById(episodeId).orElse(null);
        return episodeConverter.toDto(episode);
    }

    public List<EpisodeDto> getAllEpisodesByChapter(ChapterDto chapterDto) {
        Chapter chapter = chapterConverter.toEntity(chapterDto);
        List<Episode> episodes = episodeRepository.findAllByChapter(chapter);
        return episodes.stream()
                .map(episodeConverter::toDto)
                .toList();
    }

    public Boolean isEpisodeCompleted(EpisodeDto episodeDto) {
        return episodeConverter.toEntity(episodeDto).getIsComplete();
    }

}
