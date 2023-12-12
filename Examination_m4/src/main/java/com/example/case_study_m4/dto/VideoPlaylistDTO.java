package com.example.case_study_m4.dto;

import com.example.case_study_m4.entity.Playlist;
import com.example.case_study_m4.entity.Videos;
import lombok.Data;

@Data
public class VideoPlaylistDTO {
    private long id;
    private Playlist playlist;
    private Videos videos;
}
