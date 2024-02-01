package edu.phystech.inspiration.service.converters;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Episode;
import edu.phystech.inspiration.data.Picture;
import edu.phystech.inspiration.service.dto.EpisodeDto;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component
public class EpisodeConverter {
    public EpisodeDto toDto(Episode episode) {
        EpisodeDto episodeDto = new EpisodeDto();
        episodeDto.setIdPicture(episode.getIdPicture());
        episodeDto.setNum(episode.getNum());
        episodeDto.setText(episode.getText());
        episodeDto.setIsComplete(episode.getIsComplete());
        episodeDto.setChapter(episode.getChapter());
        return episodeDto;
    }

    public Episode toEntity(EpisodeDto episodeDto) {
        Episode episode = new Episode();
        episode.setIdPicture(episodeDto.getIdPicture());
        episode.setNum(episodeDto.getNum());
        episode.setText(episodeDto.getText());
        episode.setIsComplete(episodeDto.getIsComplete());
        episode.setChapter(episodeDto.getChapter());
        return episode;
    }
}
