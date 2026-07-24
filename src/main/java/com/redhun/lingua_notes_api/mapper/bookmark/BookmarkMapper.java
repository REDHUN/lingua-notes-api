package com.redhun.lingua_notes_api.mapper.bookmark;


import com.redhun.lingua_notes_api.dto.bookmark.BookmarkRequest;
import com.redhun.lingua_notes_api.dto.bookmark.BookmarkResponse;
import com.redhun.lingua_notes_api.entity.bookmarks.Bookmark;

public class BookmarkMapper {

  public static Bookmark toEntity(BookmarkRequest request){
      return new Bookmark();
  }
  public static BookmarkResponse toResponse(Bookmark bookmark){
      BookmarkResponse bookmarkResponse=new BookmarkResponse();
      bookmarkResponse.setBookmarkId(bookmark.getId());
      bookmarkResponse.setMalayalam(bookmark.getPattern().getMalayalam());
      bookmarkResponse.setEnglish(bookmark.getPattern().getEnglish());
      bookmarkResponse.setPatternId(bookmark.getPattern().getId());

      return bookmarkResponse;
  }


}
