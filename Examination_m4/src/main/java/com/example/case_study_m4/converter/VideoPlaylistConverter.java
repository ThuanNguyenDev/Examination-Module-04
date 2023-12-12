package com.example.case_study_m4.converter;

import com.example.case_study_m4.dto.VideoPlaylistDTO;
import com.example.case_study_m4.entity.VideoPlaylist;
import org.springframework.stereotype.Component;

@Component
public class VideoPlaylistConverter {

    public VideoPlaylistDTO toVideoPlaylistDTO (VideoPlaylist videoPlaylist) {
        VideoPlaylistDTO videoPlaylistDTO = new VideoPlaylistDTO();
        videoPlaylistDTO.setId(videoPlaylist.getId());
        videoPlaylistDTO.setPlaylist(videoPlaylist.getPlaylist());
        videoPlaylistDTO.setVideos(videoPlaylist.getVideos());
        return videoPlaylistDTO;
    }

    public VideoPlaylist toVideoPlaylist ( VideoPlaylistDTO videoPlaylistDTO) {
        VideoPlaylist videoPlaylist = new VideoPlaylist();
        videoPlaylist.setId(videoPlaylistDTO.getId());
        videoPlaylist.setVideos(videoPlaylistDTO.getVideos());
        videoPlaylist.setPlaylist(videoPlaylistDTO.getPlaylist());
        return videoPlaylist;
    }

}
