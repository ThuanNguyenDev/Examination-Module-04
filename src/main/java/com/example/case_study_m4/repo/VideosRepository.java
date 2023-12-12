package com.example.case_study_m4.repo;

import com.example.case_study_m4.entity.Videos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideosRepository extends CrudRepository <Videos,Long> {
}
