package com.example.case_study_m4.dto.request;

import lombok.Data;

import java.util.List;


@Data
public class CreateVideoRequestDTO {
    private String title;
    private String url;
    private String description;
    private List<Long> playlistIds;
}
