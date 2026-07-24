package com.redhun.lingua_notes_api.dto.dashboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCardDto {

    private Long id;

    private String name;

    private long lessonCount;

}