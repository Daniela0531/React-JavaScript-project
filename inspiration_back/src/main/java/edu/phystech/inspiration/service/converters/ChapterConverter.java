package edu.phystech.inspiration.service.converters;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.service.dto.ChapterDto;
import org.springframework.stereotype.Component;

@Component
public class ChapterConverter {
    public ChapterDto toDto(Chapter chapter) {
        ChapterDto chapterDto = new ChapterDto();
        chapterDto.setStoryId(chapter.getStory());
        chapterDto.setNum(chapter.getNum());
        chapterDto.setEpisodes(chapter.getEpisodes());
        return chapterDto;
    }

    public Chapter toEntity(ChapterDto chapterDto) {
        Chapter chapter = new Chapter();
        chapter.setStory(chapterDto.getStoryId());
        chapter.setNum(chapterDto.getNum());
        chapter.setEpisodes(chapterDto.getEpisodes());
        return chapter;
    }
}