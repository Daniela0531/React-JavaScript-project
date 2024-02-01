package edu.phystech.inspiration.service.dto;

import edu.phystech.inspiration.data.Chapter;
import edu.phystech.inspiration.data.Picture;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDto {
    private Picture idPicture;
    private Long num;
    private Boolean isComplete;
    private String text;
    private Chapter chapter;
}
