//package com.example.case_study_m4.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//
//@Entity
//@Table(name="video_list")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class VideoPlaylist {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @ManyToOne
//    @JoinColumn(name="playlist_id",referencedColumnName = "id")
//    private Playlist playlist;
//
//    @ManyToOne
//    @JoinColumn(name="videos_id",referencedColumnName = "id")
//    private Videos videos;
//
//
//
//}
