package com.redhun.lingua_notes_api.repository.bookmark;

import com.redhun.lingua_notes_api.entity.bookmarks.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository  extends JpaRepository<Bookmark,Long> {

    boolean existsByPatternId(Long patternId);
}
