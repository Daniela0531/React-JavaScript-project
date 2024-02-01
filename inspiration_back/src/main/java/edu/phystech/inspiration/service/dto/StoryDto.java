package edu.phystech.inspiration.service.dto;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryDto {
    private List<Chapter> chapters;
    private User user;
    private String name;
}
