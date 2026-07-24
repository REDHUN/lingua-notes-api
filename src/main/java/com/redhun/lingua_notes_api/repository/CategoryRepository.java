package com.redhun.lingua_notes_api.repository;

import com.redhun.lingua_notes_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository<Category,Long> {


}
