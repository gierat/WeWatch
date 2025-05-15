package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<String> getAllCategoryNames() {
        return categoryRepository.findAll().stream()
                .map(c -> c.getName())
                .toList();
    }
}