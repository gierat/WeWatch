package com.tomaszgierat.wewatch_backend.service;


import com.tomaszgierat.wewatch_backend.dto.response.MovieResponse;
import com.tomaszgierat.wewatch_backend.mapper.MovieMapper;
import com.tomaszgierat.wewatch_backend.model.Category;
import com.tomaszgierat.wewatch_backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<String> getAllCategoryNames() {
        return categoryRepository.findAll().stream()
                .map(Category::getName)
                .toList();
    }

    public Optional<List<MovieResponse>> getMoviesByCategory(String name) {
        return categoryRepository.findByNameIgnoreCase(name)
                .map(category -> category.getMovies().stream()
                        .map(MovieMapper::mapToResponse)
                        .toList());
    }
}