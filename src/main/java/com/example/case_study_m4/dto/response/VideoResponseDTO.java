package com.example.case_study_m4.dto.response;


import lombok.Data;

import java.util.List;

@Data
public class VideoResponseDTO {
    private long id;
    private String title;
    private String description;
    private List<PlaylistResponseDTO> playlistResponseDTOList;
}
