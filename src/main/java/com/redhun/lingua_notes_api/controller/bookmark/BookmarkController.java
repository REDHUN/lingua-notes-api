package com.redhun.lingua_notes_api.controller.bookmark;

import com.redhun.lingua_notes_api.dto.bookmark.BookmarkRequest;
import com.redhun.lingua_notes_api.dto.bookmark.BookmarkResponse;
import com.redhun.lingua_notes_api.service.bookmark.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    @GetMapping
    public List<BookmarkResponse> getAllBookmarks(){
        return bookmarkService.getAllBookmark() ;
    }
    @PostMapping
    public ResponseEntity<?> createBookmark(@RequestBody BookmarkRequest request) {
        try {
            BookmarkResponse response = bookmarkService.createBookmark(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalStateException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public void deleteBookmark(@PathVariable Long id){
        bookmarkService.deleteBookmark(id);
    }

    @GetMapping("/check/{patternId}")
    public boolean isBookmarked(@PathVariable Long patternId){
        return  bookmarkService.isBookmarked(patternId);
    }
}
