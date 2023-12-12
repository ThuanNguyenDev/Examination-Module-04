package com.example.case_study_m4.controller.rest;

import com.example.case_study_m4.dto.VideoPlaylistDTO;
import com.example.case_study_m4.entity.VideoPlaylist;
import com.example.case_study_m4.service.PlaylistService;
import com.example.case_study_m4.service.VideoPlaylistService;
import com.example.case_study_m4.service.VideosService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VideosManagementRestController {

    @Autowired
    private VideoPlaylistService videoPlaylistService;

    @PostMapping("/add")
    public ResponseEntity<VideoPlaylistDTO> addVideo(@RequestBody VideoPlaylistDTO videoPlaylistDTO) {
        VideoPlaylistDTO newVideoPlaylist = videoPlaylistService.addVideoPlaylist(videoPlaylistDTO);
        return new ResponseEntity<>(newVideoPlaylist, HttpStatus.CREATED);
    }

    @GetMapping("/show")
    public ResponseEntity<List<VideoPlaylistDTO>> showVideoList() {
        List<VideoPlaylistDTO> videoPlaylistDTOList = videoPlaylistService.showAllVideoPlaylist();
        return new ResponseEntity<>(videoPlaylistDTOList, HttpStatus.OK);
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<VideoPlaylistDTO> updateVideo(@PathVariable Long id, @RequestBody VideoPlaylistDTO videoPlaylistDTO) {
        VideoPlaylistDTO updateVideoPlaylist = videoPlaylistService.updateVideoPlaylist(id, videoPlaylistDTO);
        if (updateVideoPlaylist != null) {
            return new ResponseEntity<>(updateVideoPlaylist, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVideos(@PathVariable Long id) {
        boolean deleted = videoPlaylistService.deleteVideoPlaylist(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



