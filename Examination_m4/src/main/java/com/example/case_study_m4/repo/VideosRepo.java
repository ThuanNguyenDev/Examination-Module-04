package com.example.case_study_m4.repo;

import com.example.case_study_m4.entity.VideoPlaylist;
import com.example.case_study_m4.entity.Videos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideosRepo extends CrudRepository <Videos,Long> {
}
