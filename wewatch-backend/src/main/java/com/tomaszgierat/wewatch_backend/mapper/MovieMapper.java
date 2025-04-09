package com.tomaszgierat.wewatch_backend.mapper;

import com.tomaszgierat.wewatch_backend.dto.response.MovieResponse;
import com.tomaszgierat.wewatch_backend.model.Movie;
import java.util.stream.Collectors;

public class MovieMapper {
    public static MovieResponse mapToResponse(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .imagePath(movie.getImagePath())
                .categories(movie.getCategories().stream()
                        .map(cat -> cat.getName())
                        .collect(Collectors.toList()))
                .build();
    }
}