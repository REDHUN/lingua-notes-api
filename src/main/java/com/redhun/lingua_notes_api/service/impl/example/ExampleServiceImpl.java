package com.redhun.lingua_notes_api.service.impl.example;

import com.redhun.lingua_notes_api.dto.example.ExampleRequest;
import com.redhun.lingua_notes_api.dto.example.ExampleResponse;
import com.redhun.lingua_notes_api.entity.examples.Examples;
import com.redhun.lingua_notes_api.entity.pattern.Pattern;
import com.redhun.lingua_notes_api.mapper.examples.ExamplesMapper;
import com.redhun.lingua_notes_api.repository.examples.ExamplesRepository;
import com.redhun.lingua_notes_api.repository.pattern.PatternRepository;
import com.redhun.lingua_notes_api.service.examples.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    ExamplesRepository examplesRepository;
    @Autowired
    PatternRepository patternRepository;

    @Override
    public ExampleResponse createExample(ExampleRequest request) {
        Examples example= ExamplesMapper.toEntity(request);
        Pattern pattern= patternRepository.findById(request.getPatternId()).orElseThrow(() -> new RuntimeException("No Pattern Found"));
        example.setPattern(pattern);
           Examples savedExample=     examplesRepository.save(example);
        return ExamplesMapper.toResponse(savedExample);
    }

    @Override
    public List<ExampleResponse> findAllExample() {
        List<Examples> examples=examplesRepository.findAll();

        return examples.stream().map(ExamplesMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ExampleResponse updateExample(ExampleRequest request,Long id) {
        Examples example=examplesRepository.findById(id).orElseThrow(() -> new RuntimeException("Example Not Found"));


   ExamplesMapper.updateEntity(request,example);
   Examples updatedExample=examplesRepository.save(example);
        return ExamplesMapper.toResponse(updatedExample);
    }

    @Override
    public ExampleResponse findExampleById(Long id) {

        Examples example=examplesRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Example Not Found")
        );
        return ExamplesMapper.toResponse(example);
    }

    @Override
    public void deleteExample(Long id) {
        if(!examplesRepository.existsById(id)){
           throw  new RuntimeException("Example Not Found");
        }
        examplesRepository.deleteById(id);
    }

    @Override
    public List<ExampleResponse> findAllExamplesByPatternId(Long patternId) {
        List<Examples>examples=examplesRepository.findByPatternId(patternId);
        return examples.stream().map(ExamplesMapper::toResponse).collect(Collectors.toList());
    }
}
