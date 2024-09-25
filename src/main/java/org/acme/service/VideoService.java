package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.acme.ResourceNotFoundException;
import org.acme.model.Video;
import org.acme.model.dto.VideoDTO;
import org.acme.model.mapper.VideoMapper;
import org.acme.repository.VideoRepository;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class VideoService {

    final private VideoRepository videoRepository;
    final private VideoMapper videoMapper;

    @Transactional
    public VideoDTO findById(Long id) {
        return videoRepository.findByIdOptional(id)
                .map(videoMapper::toVideoDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found"));
    }

    @Transactional
    public List<VideoDTO> findAll() {
        return videoRepository.findAll().stream().map(videoMapper::toVideoDTO).toList();
    }

    @Transactional
    public VideoDTO save(VideoDTO videoDTO) {
        final Video video = videoMapper.toVideo(videoDTO);
        videoRepository.persist(video);
        return videoMapper.toVideoDTO(video);
    }

    @Transactional
    public VideoDTO update(Long id, VideoDTO updateVideoDTO) {
        final Video video = videoRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found"));
        video.setName(updateVideoDTO.getName());
        video.setLink(updateVideoDTO.getLink());
        videoRepository.persist(video);

        return videoMapper.toVideoDTO(video);
    }

    @Transactional
    public void delete(Long id) {
        final VideoDTO videoDTO = findById(id);
        final Video video = videoMapper.toVideo(videoDTO);
        videoRepository.delete(video);
    }
}
