package com.redhun.lingua_notes_api.repository.examples;

import com.redhun.lingua_notes_api.entity.examples.Examples;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamplesRepository extends JpaRepository<Examples,Long> {

    List<Examples> findByPatternId(Long patternId);
}
