package com.example.case_study_m4.service;

import com.example.case_study_m4.dto.VideoPlaylistDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoPlaylistService {
    VideoPlaylistDTO addVideoPlaylist(VideoPlaylistDTO videoPlaylistDTO);

    VideoPlaylistDTO updateVideoPlaylist(Long id, VideoPlaylistDTO videoPlaylistDTO);

    boolean deleteVideoPlaylist(Long id);

    List<VideoPlaylistDTO> showAllVideoPlaylist();

    VideoPlaylistDTO findVideoPlaylistDTObyId(Long id);


}
