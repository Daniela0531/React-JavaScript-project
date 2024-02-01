package edu.phystech.inspiration.data.repo;

import edu.phystech.inspiration.data.Story;
import edu.phystech.inspiration.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findAllByUser(User user);
}
