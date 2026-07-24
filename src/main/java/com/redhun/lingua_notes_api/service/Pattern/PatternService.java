package com.redhun.lingua_notes_api.service.Pattern;

import com.redhun.lingua_notes_api.dto.patterns.PatternRequest;
import com.redhun.lingua_notes_api.dto.patterns.PatternResponse;

import java.util.List;


public interface PatternService {

   PatternResponse createPattern(PatternRequest request);

   List<PatternResponse> findAll();

    PatternResponse updatePattern(PatternRequest request,Long id);

    PatternResponse findPatternById(Long id);

    void deletePattern(Long id);

List<PatternResponse>findPatternsByCategoryId(Long id);
}
