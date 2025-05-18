package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.dto.response.MovieResponse;
import com.tomaszgierat.wewatch_backend.mapper.MovieMapper;
import com.tomaszgierat.wewatch_backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<String>> getAllCategoryNames() {
        List<String> categoryNames = categoryRepository.findAll().stream()
                .map(c -> c.getName())
                .collect(Collectors.toList());

        return ResponseEntity.ok(categoryNames);
    }
}