package com.tomaszgierat.wewatch_backend.repository;

import com.tomaszgierat.wewatch_backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByImagePathContainingIgnoreCase(String partialPath);
    List<Movie> findByCategories_NameIgnoreCase(String name);

}