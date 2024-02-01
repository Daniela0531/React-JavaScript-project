package edu.phystech.inspiration.service;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Episode;
import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.data.repo.ChapterRepository;
import edu.phystech.inspiration.service.converters.ChapterConverter;
import edu.phystech.inspiration.service.converters.EpisodeConverter;
import edu.phystech.inspiration.service.converters.StoryConverter;
import edu.phystech.inspiration.service.dto.ChapterDto;
import edu.phystech.inspiration.service.dto.EpisodeDto;
import edu.phystech.inspiration.service.dto.StoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChapterService {
    private final ChapterRepository chapterRepository;
    private final EpisodeConverter episodeConverter;
    private final ChapterConverter chapterConverter;
    private final StoryConverter storyConverter;

    public ChapterDto addChapter(ChapterDto chapterDto) {
        Chapter chapter = chapterConverter.toEntity(chapterDto);
        Chapter savedChapter = chapterRepository.save(chapter);
        return chapterConverter.toDto(savedChapter);
    }

    public void deleteChapter(Long chapterId) {
        chapterRepository.deleteById(chapterId);
    }

    public ChapterDto updateChapter(Long chapterId, ChapterDto chapterDto) {
        Chapter existingChapter = chapterRepository.findById(chapterId).orElse(null);
        if (existingChapter == null) {
            return null;
        }

        existingChapter.setStory(chapterDto.getStoryId());
        existingChapter.setNum(chapterDto.getNum());
        existingChapter.setEpisodes(chapterDto.getEpisodes());

        Chapter updatedChapter = chapterRepository.save(existingChapter);
        return chapterConverter.toDto(updatedChapter);
    }

    public ChapterDto getChapterById(Long chapterId) {
        Chapter chapter = chapterRepository.findById(chapterId).orElse(null);
        return chapterConverter.toDto(chapter);
    }

    public List<EpisodeDto> getEpisodes(ChapterDto chapterDto) {
        List<Episode> episodes = chapterConverter.toEntity(chapterDto).getEpisodes();
        return episodes.stream()
                .map(episodeConverter::toDto)
                .toList();
    }

    public List<EpisodeDto> getCompletedEpisodes(ChapterDto chapterDto) {
        List<Episode> episodes = chapterConverter.toEntity(chapterDto).getEpisodes();
        return episodes.stream()
                .map(episodeConverter::toDto)
                .filter(EpisodeDto::getIsComplete)
                .toList();
    }

    public List<ChapterDto> getAllChaptersByStory(StoryDto storyDto) {
        Story story = storyConverter.toEntity(storyDto);
        List<Chapter> chapters = chapterRepository.findAllByStory(story);
        return chapters.stream()
                .map(chapterConverter::toDto)
                .toList();
    }

    public Boolean isCompleted(ChapterDto chapterDto) {
        List<Episode> chapterEpisodes = chapterConverter.toEntity(chapterDto).getEpisodes();
        for (Episode episode : chapterEpisodes) {
            if (!episode.getIsComplete()) {
                return false;
            }
        }
        return true;
    }

}
