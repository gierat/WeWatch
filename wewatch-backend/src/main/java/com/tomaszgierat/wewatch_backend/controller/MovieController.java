package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.mapper.MovieMapper;
import com.tomaszgierat.wewatch_backend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.mapToResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }
}