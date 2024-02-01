package edu.phystech.inspiration.service.dto;

import edu.phystech.inspiration.data.Episode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PictureDto {
    private List<Episode> episodes;
    private String imageURI;
}
