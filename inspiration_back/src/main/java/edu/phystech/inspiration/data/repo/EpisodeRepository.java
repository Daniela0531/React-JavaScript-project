package edu.phystech.inspiration.data.repo;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    public List<Episode> findAllByChapter(Chapter chapter);
}
