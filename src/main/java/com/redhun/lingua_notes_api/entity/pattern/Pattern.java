package com.redhun.lingua_notes_api.entity.pattern;

import com.redhun.lingua_notes_api.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patterns")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Pattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String malayalam;

    private String english;

    private String meaning;

    private String notes;



    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
