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

    private String title;
    private String description;
}
