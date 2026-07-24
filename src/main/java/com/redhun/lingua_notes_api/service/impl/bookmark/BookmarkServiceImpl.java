package com.redhun.lingua_notes_api.service.impl.bookmark;

import com.redhun.lingua_notes_api.dto.bookmark.BookmarkRequest;
import com.redhun.lingua_notes_api.dto.bookmark.BookmarkResponse;
import com.redhun.lingua_notes_api.entity.bookmarks.Bookmark;
import com.redhun.lingua_notes_api.entity.pattern.Pattern;
import com.redhun.lingua_notes_api.mapper.bookmark.BookmarkMapper;
import com.redhun.lingua_notes_api.repository.bookmark.BookmarkRepository;
import com.redhun.lingua_notes_api.repository.pattern.PatternRepository;
import com.redhun.lingua_notes_api.service.bookmark.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    BookmarkRepository bookmarkRepository;
    @Autowired
    PatternRepository patternRepository;


    @Override
    public BookmarkResponse createBookmark(BookmarkRequest bookmarkRequest) {

        if (bookmarkRepository.existsByPatternId(bookmarkRequest.getPatternId())) {
            throw new IllegalStateException("Pattern is already bookmarked");
        }
        Pattern pattern=patternRepository.findById(bookmarkRequest.getPatternId()).orElseThrow(() -> new RuntimeException(("Pattern not found")));
        Bookmark bookmark= BookmarkMapper.toEntity(bookmarkRequest);
        bookmark.setPattern(pattern);
        Bookmark savedBookmark=bookmarkRepository.save(bookmark);
        return BookmarkMapper.toResponse(savedBookmark);
    }

    @Override
    public List<BookmarkResponse> getAllBookmark() {
        List<Bookmark> bookmarkList=bookmarkRepository.findAll();
        return bookmarkList.stream().map(BookmarkMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public void deleteBookmark(Long id) {
        if(!bookmarkRepository.existsById(id)){
            throw new RuntimeException("Bookmark not found");
        }
        bookmarkRepository.deleteById(id);

    }

    @Override
    public boolean isBookmarked(Long patternId) {
        return bookmarkRepository.existsByPatternId(patternId);
    }
}
