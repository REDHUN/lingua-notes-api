package com.redhun.lingua_notes_api.repository.userprogress;

import com.redhun.lingua_notes_api.entity.userprogress.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProgressRepository
        extends JpaRepository<UserProgress, Long> {

    Optional<UserProgress> findByUserId(Long userId);


}