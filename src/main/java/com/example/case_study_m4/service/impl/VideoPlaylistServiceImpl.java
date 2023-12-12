package com.example.case_study_m4.service.impl;

import com.example.case_study_m4.converter.VideosConverter;
import com.example.case_study_m4.dto.request.CreateVideoRequestDTO;
import com.example.case_study_m4.dto.response.VideoResponseDTO;
import com.example.case_study_m4.entity.Playlist;
import com.example.case_study_m4.entity.Videos;
import com.example.case_study_m4.repo.PlayListRepository;
import com.example.case_study_m4.repo.VideosRepository;
import com.example.case_study_m4.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoPlaylistServiceImpl implements VideosService {

    @Autowired
    private VideosRepository videoRepository;

    @Autowired
    private PlayListRepository playlistRepository;

    @Autowired
    private VideosConverter videosConverter;

    public VideoResponseDTO addVideoWithPlaylists(CreateVideoRequestDTO videoWithPlaylistsDTO) {

        Videos video = videosConverter.convertDTOtoEntity(videoWithPlaylistsDTO);

        videoRepository.save(video);

        List<Long> playlistIds = videoWithPlaylistsDTO.getPlaylistIds();

        List<Playlist> playlistList = new ArrayList<>();

        for (Long playlistId : playlistIds) {
            Playlist playlist = playlistRepository.findById(playlistId)
                    .orElseThrow(() -> new EntityNotFoundException("Playlist not found"));
            playlistList.add(playlist);
        }

        video.setPlaylistList(playlistList);

        videoRepository.save(video);

        return videosConverter.convertEntityToDTO(video);
    }

    @Override
    public List<VideoResponseDTO> getAllVideos() {
        List<Videos> videos = (List<Videos>) videoRepository.findAll();
        return videosConverter.convertEntityToDTOList(videos);
    }

    public void deleteVideo(Long videoId) {

        Videos existingVideo = videoRepository.findById(videoId)
                .orElseThrow(() -> new EntityNotFoundException("Video not found"));
        videoRepository.delete(existingVideo);
    }

    @Override
    public VideoResponseDTO findVideoById(Long videoId) {
        Videos existingVideo = videoRepository.findById(videoId)
                .orElseThrow(() -> new EntityNotFoundException("Video not found"));
        return videosConverter.convertEntityToDTO(existingVideo);
    }

    public VideoResponseDTO updateVideo(Long videoId, CreateVideoRequestDTO updatedVideoDTO) {

        Videos existingVideo = videoRepository.findById(videoId)
                .orElseThrow(() -> new EntityNotFoundException("Video not found"));


        existingVideo.setTitle(updatedVideoDTO.getTitle());
        existingVideo.setUrl(updatedVideoDTO.getUrl());
        existingVideo.setDescription(updatedVideoDTO.getDescription());

        List<Long> playlistIds = updatedVideoDTO.getPlaylistIds();

        List<Playlist> playlistList = new ArrayList<>();

        for (Long playlistId : playlistIds) {
            Playlist playlist = playlistRepository.findById(playlistId)
                    .orElseThrow(() -> new EntityNotFoundException("Playlist not found"));
            playlistList.add(playlist);
        }

        existingVideo.setPlaylistList(playlistList);


        Videos updatedVideo = videoRepository.save(existingVideo);

        return videosConverter.convertEntityToDTO(updatedVideo);
    }

}
