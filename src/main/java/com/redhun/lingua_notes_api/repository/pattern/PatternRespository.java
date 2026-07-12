package com.redhun.lingua_notes_api.repository.pattern;

import com.redhun.lingua_notes_api.entity.pattern.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatternRespository extends JpaRepository<Pattern,Long> {
}
