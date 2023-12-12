package com.example.case_study_m4.entity;


import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="playlist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "title")
    private String title;


    @ManyToMany(mappedBy = "playlistList")
    private List<Videos> videosList;
}
