package com.example.case_study_m4.controller;

import com.example.case_study_m4.dto.request.CreateVideoRequestDTO;
import com.example.case_study_m4.dto.response.VideoResponseDTO;
import com.example.case_study_m4.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class VideosManagementRestController {

    @Autowired
    private VideosService videosService;

    @PostMapping("/add")
    public ResponseEntity<VideoResponseDTO> addVideoWithPlaylists(@RequestBody CreateVideoRequestDTO videoWithPlaylistsDTO) {
        VideoResponseDTO newVideo = videosService.addVideoWithPlaylists(videoWithPlaylistsDTO);
        return new ResponseEntity<>(newVideo, HttpStatus.CREATED);
    }

    @GetMapping("/show")
    public ResponseEntity<List<VideoResponseDTO>> getAllVideos() {
        List<VideoResponseDTO> videos = videosService.getAllVideos();
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @PutMapping("/update/{videoId}")
    public ResponseEntity<VideoResponseDTO> updateVideo(@PathVariable Long videoId, @RequestBody CreateVideoRequestDTO updatedVideoDTO) {
        VideoResponseDTO updatedVideo = videosService.updateVideo(videoId, updatedVideoDTO);
        return new ResponseEntity<>(updatedVideo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{videoId}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long videoId) {
        videosService.deleteVideo(videoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{videoId}")
    public ResponseEntity<VideoResponseDTO> findVideoById(@PathVariable Long videoId) {
        VideoResponseDTO  foundVideo = videosService.findVideoById(videoId);
        return new ResponseEntity<>(foundVideo, HttpStatus.OK);
    }



}



