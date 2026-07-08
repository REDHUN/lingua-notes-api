    package com.redhun.lingua_notes_api.dto;

    import lombok.Getter;
    import lombok.Setter;

    @Getter
    @Setter
    public class CategoryRequest {

        private String name;

        private String description;

        private String icon;

    }