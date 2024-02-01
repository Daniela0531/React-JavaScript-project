package edu.phystech.inspiration.data.repo;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    public List<Chapter> findAllByStory(Story storyId);
}
