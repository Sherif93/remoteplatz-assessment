package com.remoteplatz.assessment.repository;

import com.remoteplatz.assessment.model.MovieCategory;
import com.remoteplatz.assessment.model.MovieCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCategoryRepository extends JpaRepository<MovieCategory, MovieCategoryId> {
}
