package com.redhun.lingua_notes_api.dto.bookmark;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkResponse {
    private Long bookmarkId;
    private Long patternId;
    private String english;
    private String malayalam;
}
