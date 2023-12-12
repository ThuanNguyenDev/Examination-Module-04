package com.example.case_study_m4.service;

import com.example.case_study_m4.dto.request.CreateVideoRequestDTO;
import com.example.case_study_m4.dto.response.VideoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideosService {

    VideoResponseDTO addVideoWithPlaylists(CreateVideoRequestDTO videoWithPlaylistsDTO) ;

    List<VideoResponseDTO> getAllVideos();

    VideoResponseDTO updateVideo(Long videoId, CreateVideoRequestDTO updatedVideoDTO);

    void deleteVideo(Long videoId);

    VideoResponseDTO findVideoById(Long videoId);
}
