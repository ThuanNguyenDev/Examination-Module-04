package com.example.case_study_m4.service.impl;

import com.example.case_study_m4.converter.PlaylistConverter;
import com.example.case_study_m4.converter.VideoPlaylistConverter;
import com.example.case_study_m4.converter.VideosConverter;
import com.example.case_study_m4.dto.VideoPlaylistDTO;
import com.example.case_study_m4.entity.VideoPlaylist;
import com.example.case_study_m4.entity.Videos;
import com.example.case_study_m4.repo.PlayListRepo;
import com.example.case_study_m4.repo.VideoPlaylistRepo;
import com.example.case_study_m4.repo.VideosRepo;
import com.example.case_study_m4.service.VideoPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VideoPlaylistServiceImpl implements VideoPlaylistService {
    @Autowired
    private VideoPlaylistRepo videoPlaylistRepo;
    @Autowired
    private PlayListRepo playListRepo;
    @Autowired
    private VideosRepo videosRepo;

    @Autowired
    private VideoPlaylistConverter videoPlaylistConverter;
    @Autowired
    private PlaylistConverter playlistConverter;
    @Autowired
    private VideosConverter videosConverter;


    @Override
    public VideoPlaylistDTO addVideoPlaylist(VideoPlaylistDTO videoPlaylistDTO) {
        VideoPlaylist videoPlaylist = videoPlaylistConverter.toVideoPlaylist(videoPlaylistDTO);
        VideoPlaylist savedVideoPlaylist = (VideoPlaylist) videoPlaylistRepo.save(videoPlaylist);
        return videoPlaylistConverter.toVideoPlaylistDTO(savedVideoPlaylist);
    }

    @Override
    public VideoPlaylistDTO updateVideoPlaylist(Long id, VideoPlaylistDTO videoPlaylistDTO) {
        Optional<VideoPlaylist> videoPlaylistOptional = videoPlaylistRepo.findById(id);
        if (videoPlaylistOptional.isPresent()) {
            VideoPlaylist existVideoPlaylist = videoPlaylistOptional.get();
            existVideoPlaylist.setId(videoPlaylistDTO.getId());
            existVideoPlaylist.setPlaylist(videoPlaylistDTO.getPlaylist());
            existVideoPlaylist.setVideos(videoPlaylistDTO.getVideos());
            VideoPlaylist updateVideoPlaylist = (VideoPlaylist) videoPlaylistRepo.save(existVideoPlaylist);
            return videoPlaylistConverter.toVideoPlaylistDTO(updateVideoPlaylist);

        } else {
            return null;
        }
    }

    @Override
    public boolean deleteVideoPlaylist(Long id) {
        Optional<VideoPlaylist> videoPlaylistptional = videoPlaylistRepo.findById(id);
        if (videoPlaylistptional.isPresent()) {
            videoPlaylistRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<VideoPlaylistDTO> showAllVideoPlaylist() {
        Iterable<VideoPlaylist> videoPlaylistIterable = videoPlaylistRepo.findAll();


        List<VideoPlaylistDTO> videoPlaylistDTOs = StreamSupport.stream(videoPlaylistIterable.spliterator(), false)
                .map(videoPlaylistConverter::toVideoPlaylistDTO)
                .collect(Collectors.toList());

        return videoPlaylistDTOs;
    }

    @Override
    public VideoPlaylistDTO findVideoPlaylistDTObyId(Long id) {
        Optional< VideoPlaylist>  videoPlaylistOptional = videoPlaylistRepo.findById(id);
        if (videoPlaylistOptional.isPresent()) {
            return videoPlaylistConverter.toVideoPlaylistDTO(videoPlaylistOptional.get());
        } else {
            return null;
        }
    }
}
