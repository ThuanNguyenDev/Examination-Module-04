package com.example.case_study_m4.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
}
