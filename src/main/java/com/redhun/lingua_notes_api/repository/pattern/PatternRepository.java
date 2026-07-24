package com.redhun.lingua_notes_api.repository.pattern;

import com.redhun.lingua_notes_api.entity.pattern.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatternRepository extends JpaRepository<Pattern,Long> {
    List<Pattern> findByCategoryId(Long categoryId);

}
