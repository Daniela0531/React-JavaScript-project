package edu.phystech.inspiration.service.converters;

import edu.phystech.inspiration.data.Picture;
import edu.phystech.inspiration.data.Picture;
import edu.phystech.inspiration.service.dto.PictureDto;
import edu.phystech.inspiration.service.dto.PictureDto;
import org.springframework.stereotype.Component;

@Component
public class PictureConvecter {
    public PictureDto toDto(Picture picture) {
        PictureDto pictureDto = new PictureDto();
        pictureDto.setImageURI(picture.getImageURI());
        pictureDto.setEpisodes(picture.getEpisodes());
        return pictureDto;
    }

    public Picture toEntity(PictureDto pictureDto) {
        Picture picture = new Picture();
        picture.setImageURI(pictureDto.getImageURI());
        picture.setEpisodes(pictureDto.getEpisodes());
        return picture;
    }
}