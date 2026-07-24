package com.redhun.lingua_notes_api.controller.examples;

import com.redhun.lingua_notes_api.dto.example.ExampleRequest;
import com.redhun.lingua_notes_api.dto.example.ExampleResponse;
import com.redhun.lingua_notes_api.service.examples.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examples")
public class ExamplesController {

    @Autowired
    ExampleService exampleService;

    @PostMapping
    public ExampleResponse createExample(@RequestBody ExampleRequest request){
        return exampleService.createExample(request);
    }
    @PutMapping("/{id}")
    public  ExampleResponse updateExample(@RequestBody ExampleRequest request ,@PathVariable Long id){
        return exampleService.updateExample(request,id);
    }
    @DeleteMapping("/{id}")
    public void deleteExample(@PathVariable Long id){
        exampleService.deleteExample(id);
    }
    @GetMapping()
    public List<ExampleResponse> getExample(){
        return exampleService.findAllExample();
    }
    @GetMapping("/{id}")
    public ExampleResponse getExampleById(@PathVariable Long id){
        return exampleService.findExampleById(id);
    }
    @GetMapping("/pattern/{patternId}")
    public List<ExampleResponse> getAllExampleByPatternId(@PathVariable Long patternId){
        return  exampleService.findAllExamplesByPatternId(patternId);
    }
}
