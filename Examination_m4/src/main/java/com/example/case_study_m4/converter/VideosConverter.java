package com.example.case_study_m4.converter;

import com.example.case_study_m4.dto.VideosDTO;
import com.example.case_study_m4.entity.Videos;
import org.springframework.stereotype.Component;

@Component
public class VideosConverter {
    public Videos toVideos (VideosDTO videosDTO) {
        Videos videos = new Videos();
        videos.setId(videosDTO.getId());
        videos.setTitle(videosDTO.getTitle());
        videos.setDescription(videosDTO.getDescription());
        return videos;
    }

    public VideosDTO toVideosDTO (Videos videos) {
        VideosDTO videosDTO = new VideosDTO();
        videosDTO.setId(videos.getId());
        videosDTO.setTitle(videos.getTitle());
        videosDTO.setDescription(videos.getDescription());

        return videosDTO;
    }
}
