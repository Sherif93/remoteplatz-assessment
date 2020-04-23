package com.remoteplatz.assessment.repository;

import com.remoteplatz.assessment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
