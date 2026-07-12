package com.redhun.lingua_notes_api.dto.patterns;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatternRequest {

    private String malayalam;

    private String english;

    private String meaning;

    private String notes;

    private Long categoryId;
}
