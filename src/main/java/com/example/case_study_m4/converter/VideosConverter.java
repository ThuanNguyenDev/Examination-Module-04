package com.example.case_study_m4.converter;

import com.example.case_study_m4.dto.request.CreateVideoRequestDTO;

import com.example.case_study_m4.dto.response.PlaylistResponseDTO;
import com.example.case_study_m4.dto.response.VideoResponseDTO;
import com.example.case_study_m4.entity.Playlist;

import com.example.case_study_m4.entity.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VideosConverter {

    @Autowired
    private PlaylistConverter playlistConverter;

    public Videos convertDTOtoEntity (CreateVideoRequestDTO createVideoRequestDTO) {
        Videos newVi = new Videos();
        newVi.setTitle(createVideoRequestDTO.getTitle());
        newVi.setUrl(createVideoRequestDTO.getUrl());
        newVi.setDescription(createVideoRequestDTO.getDescription());
        return newVi;

    }



    public VideoResponseDTO convertEntityToDTO(Videos videos) {
        if (videos == null) {
            return null;
        }

        VideoResponseDTO videoResponseDTO = new VideoResponseDTO();
        videoResponseDTO.setId(videos.getId());
        videoResponseDTO.setTitle(videos.getTitle());
        videoResponseDTO.setDescription(videos.getDescription());
        List<PlaylistResponseDTO> playlistResponseDTOList = playlistConverter.convertEntityToDTOList(videos.getPlaylistList());
        videoResponseDTO.setPlaylistResponseDTOList(playlistResponseDTOList);

        return videoResponseDTO;
    }

    public List<VideoResponseDTO> convertEntityToDTOList(List<Videos> videosList) {
        List<VideoResponseDTO> videoResponseDTOList = new ArrayList<>();
        for (Videos videos : videosList) {
            VideoResponseDTO videoResponseDTO = convertEntityToDTO(videos);
            videoResponseDTOList.add(videoResponseDTO);
        }
        return videoResponseDTOList;
    }


}
