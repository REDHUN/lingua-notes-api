package com.redhun.lingua_notes_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CategoryResponse {

    private Long id;

    private String name;

    private String description;

    private String icon;

}