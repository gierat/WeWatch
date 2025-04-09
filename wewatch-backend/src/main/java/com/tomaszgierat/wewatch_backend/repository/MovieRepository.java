package com.tomaszgierat.wewatch_backend.repository;

import com.tomaszgierat.wewatch_backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}