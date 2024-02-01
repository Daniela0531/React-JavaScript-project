package edu.phystech.inspiration.service.dto;

import edu.phystech.inspiration.data.Episode;
import edu.phystech.inspiration.data.Story;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChapterDto {
    private Story storyId;
    private Long num;
    private List<Episode> episodes;
}
