package edu.phystech.inspiration.data.repo;

import edu.phystech.inspiration.data.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
//    Picture findById(Long id);
}
