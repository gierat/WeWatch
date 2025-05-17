package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.dto.response.MovieResponse;
import com.tomaszgierat.wewatch_backend.mapper.MovieMapper;
import com.tomaszgierat.wewatch_backend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll(Sort.by("id").ascending()).stream()
                .limit(8)
                .map(MovieMapper::mapToResponse)
                .toList();
    }
}