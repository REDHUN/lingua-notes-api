package com.redhun.lingua_notes_api.mapper.examples;

import com.redhun.lingua_notes_api.dto.example.ExampleRequest;
import com.redhun.lingua_notes_api.dto.example.ExampleResponse;
import com.redhun.lingua_notes_api.entity.examples.Examples;

public class ExamplesMapper {


    public static Examples toEntity(ExampleRequest request){

        Examples examples=new Examples();
        examples.setEnglish(request.getEnglish());
        examples.setMalayalam(request.getMalayalam());

        return examples;


    }

    public static ExampleResponse toResponse(Examples examples){
ExampleResponse exampleResponse=new ExampleResponse();
        exampleResponse.setExampleId(examples.getId());
        exampleResponse.setEnglish(examples.getEnglish());
        exampleResponse.setMalayalam(examples.getMalayalam());
        exampleResponse.setPatternId(examples.getPattern().getId());

        return exampleResponse;
    }

    public static void updateEntity(ExampleRequest exampleRequest,Examples examples){

        examples.setEnglish(exampleRequest.getEnglish());
        examples.setMalayalam(exampleRequest.getMalayalam());
    }
}
