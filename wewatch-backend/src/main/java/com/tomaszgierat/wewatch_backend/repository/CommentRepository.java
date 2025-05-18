package com.tomaszgierat.wewatch_backend.repository;

import com.tomaszgierat.wewatch_backend.model.Comment;
import com.tomaszgierat.wewatch_backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByMovieOrderByCreatedAtDesc(Movie movie);
}