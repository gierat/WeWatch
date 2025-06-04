package com.tomaszgierat.wewatch_backend.service;

import com.tomaszgierat.wewatch_backend.dto.response.MovieResponse;
import com.tomaszgierat.wewatch_backend.mapper.MovieMapper;
import com.tomaszgierat.wewatch_backend.model.Movie;
import com.tomaszgierat.wewatch_backend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Optional<MovieResponse> getMovieById(Long id) {
        return movieRepository.findById(id)
                .map(MovieMapper::mapToResponse);
    }

    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll(Sort.by("id").ascending())
                .stream()
                .limit(8)
                .map(MovieMapper::mapToResponse)
                .toList();
    }
}
