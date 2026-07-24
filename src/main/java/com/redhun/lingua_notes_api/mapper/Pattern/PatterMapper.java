package com.redhun.lingua_notes_api.mapper.Pattern;

import com.redhun.lingua_notes_api.dto.patterns.PatternRequest;
import com.redhun.lingua_notes_api.dto.patterns.PatternResponse;
import com.redhun.lingua_notes_api.entity.Category;
import com.redhun.lingua_notes_api.entity.pattern.Pattern;

public class PatterMapper {


    public static Pattern toEntity(PatternRequest patternRequest){
        Pattern pattern=new Pattern();




        pattern.setMalayalam(patternRequest.getMalayalam());
        pattern.setEnglish(patternRequest.getEnglish());
        pattern.setMeaning(patternRequest.getMeaning());
        pattern.setNotes(patternRequest.getNotes());


        return  pattern;

    }

    public static PatternResponse toResponse(
            Pattern pattern
    ){

        PatternResponse patternResponse=new PatternResponse();
        patternResponse.setPatternId(pattern.getId());
        patternResponse.setMalayalam(pattern.getMalayalam());
        patternResponse.setEnglish(pattern.getEnglish());
        patternResponse.setMeaning(pattern.getMeaning());
        patternResponse.setNotes(pattern.getNotes());
        patternResponse.setCategoryId(pattern.getCategory().getId());

        return patternResponse;



    }

    public static void updateEntity(
            PatternRequest request,Pattern pattern
    ){
        pattern.setMalayalam(request.getMalayalam());
        pattern.setEnglish(request.getEnglish());
        pattern.setMeaning(request.getMeaning());
        pattern.setNotes(request.getNotes());

    }

}
