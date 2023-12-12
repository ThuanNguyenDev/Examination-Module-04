package com.example.case_study_m4.repo;

import com.example.case_study_m4.entity.Playlist;
import com.example.case_study_m4.entity.VideoPlaylist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepo extends CrudRepository <Playlist,Long> {
}
