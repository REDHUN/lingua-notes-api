package com.redhun.lingua_notes_api.controller.Pattern;

import com.redhun.lingua_notes_api.dto.patterns.PatternRequest;
import com.redhun.lingua_notes_api.dto.patterns.PatternResponse;
import com.redhun.lingua_notes_api.service.Pattern.PatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patterns")
public class PatternController {

    @Autowired
   private PatternService patternService;

    @PostMapping
    public PatternResponse createPattern(@RequestBody PatternRequest patternRequest){
        return patternService.createPattern(patternRequest);
    }

    @GetMapping
    public List<PatternResponse> getAllPatterns(){
        return patternService.findAll();
    }

    @GetMapping("/{id}")
    public PatternResponse getPatternById(@PathVariable Long id){
        return patternService.findPatternById(id);
    }

    @PutMapping("/{id}")
    public PatternResponse updatePattern(@PathVariable Long id,@RequestBody PatternRequest request){
        return patternService.updatePattern(request,id);
    }
    @DeleteMapping("/{id}")
    public void  deletePattern(@PathVariable Long id){
         patternService.deletePattern(id);
    }
}
