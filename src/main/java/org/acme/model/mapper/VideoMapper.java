package org.acme.model.mapper;

import org.acme.model.Video;
import org.acme.model.dto.VideoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface VideoMapper {

    Video toVideo(VideoDTO videoDTO);

    VideoDTO toVideoDTO(Video video);
}
