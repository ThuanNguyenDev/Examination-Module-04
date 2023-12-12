package com.example.case_study_m4.repo;

import com.example.case_study_m4.entity.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends CrudRepository <Playlist,Long> {
}
