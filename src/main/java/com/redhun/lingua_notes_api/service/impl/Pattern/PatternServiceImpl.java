package com.redhun.lingua_notes_api.service.impl.Pattern;

import com.redhun.lingua_notes_api.dto.patterns.PatternRequest;
import com.redhun.lingua_notes_api.dto.patterns.PatternResponse;
import com.redhun.lingua_notes_api.entity.Category;
import com.redhun.lingua_notes_api.entity.pattern.Pattern;
import com.redhun.lingua_notes_api.mapper.Pattern.PatterMapper;
import com.redhun.lingua_notes_api.repository.CategoryRepository;
import com.redhun.lingua_notes_api.repository.pattern.PatternRepository;
import com.redhun.lingua_notes_api.service.Pattern.PatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatternServiceImpl implements PatternService {

    @Autowired
    PatternRepository patternRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public PatternResponse createPattern(PatternRequest request) {

        Category  category=categoryRepository.findById(request.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category not found")
        );
        Pattern pattern= PatterMapper.toEntity(request);
        pattern.setCategory(category);
        Pattern patternSaved= patternRepository.save(pattern);


        return PatterMapper.toResponse(patternSaved) ;
    }

    @Override
    public List<PatternResponse> findAll() {
        List<Pattern> patternResponseList= patternRepository.findAll();

        return patternResponseList.stream().map(PatterMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public PatternResponse updatePattern(PatternRequest request,Long id) {
        Category  category=categoryRepository.findById(request.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category not found")
        );
        Pattern pattern= patternRepository.findById(id).orElseThrow(() -> new RuntimeException("Pattern not found"));
      pattern.setCategory(category);

        PatterMapper.updateEntity(request,pattern);
Pattern updated= patternRepository.save(pattern);
        return PatterMapper.toResponse(pattern);
    }

    @Override
    public PatternResponse findPatternById(Long id) {

        Pattern pattern= patternRepository.findById(id).orElseThrow(() -> new RuntimeException("Pattern not found"));
        return PatterMapper.toResponse(pattern);
    }

    @Override
    public void deletePattern(Long id) {
        if(!patternRepository.existsById(id)){
            throw new RuntimeException("Pattern Not Found");
        }
        patternRepository.deleteById(id);

    }

    @Override
    public List<PatternResponse> findPatternsByCategoryId(Long id) {

        List<Pattern> patterns= patternRepository.findByCategoryId(id);
        return  patterns.stream().map(PatterMapper::toResponse).collect(Collectors.toList());
    }
}
