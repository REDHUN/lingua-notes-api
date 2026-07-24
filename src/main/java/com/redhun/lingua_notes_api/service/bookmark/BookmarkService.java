package com.redhun.lingua_notes_api.service.bookmark;

import com.redhun.lingua_notes_api.dto.bookmark.BookmarkRequest;
import com.redhun.lingua_notes_api.dto.bookmark.BookmarkResponse;

import java.util.List;

public interface BookmarkService {

    public BookmarkResponse createBookmark(BookmarkRequest bookmarkRequest);
    public List<BookmarkResponse>getAllBookmark();
    public void deleteBookmark(Long id);
    boolean isBookmarked(Long patternId);

}
