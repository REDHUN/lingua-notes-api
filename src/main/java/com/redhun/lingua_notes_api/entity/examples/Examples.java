package com.redhun.lingua_notes_api.entity.examples;

import com.redhun.lingua_notes_api.entity.pattern.Pattern;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "examples")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Examples {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String english;

    private String malayalam;

    @ManyToOne
    @JoinColumn(name = "pattern_id")
    private Pattern pattern;

}
