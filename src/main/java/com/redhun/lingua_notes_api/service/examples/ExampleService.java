package com.redhun.lingua_notes_api.service.examples;

import com.redhun.lingua_notes_api.dto.example.ExampleRequest;
import com.redhun.lingua_notes_api.dto.example.ExampleResponse;

import java.util.List;

public interface ExampleService {

    public ExampleResponse createExample(ExampleRequest request);
    public  List<ExampleResponse> findAllExample() ;
    public ExampleResponse updateExample(ExampleRequest request,Long id);
    public ExampleResponse findExampleById(Long id);
    public void deleteExample(Long id);
    public List<ExampleResponse> findAllExamplesByPatternId(Long patternId);

}
