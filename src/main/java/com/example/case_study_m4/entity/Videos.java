package com.example.case_study_m4.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="videos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Videos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title")
    private String title;

    @JoinColumn(name="url")
    private String url;

    @JoinColumn(name="description")
    private String description;


    @ManyToMany
    @JoinTable(
            name = "video_playlist",
            joinColumns = @JoinColumn(name = "video_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    private List<Playlist> playlistList;
}
