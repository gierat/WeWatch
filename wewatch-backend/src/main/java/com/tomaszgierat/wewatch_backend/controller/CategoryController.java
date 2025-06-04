package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.dto.response.MovieResponse;
import com.tomaszgierat.wewatch_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Get all category names")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned list of category names")
    })
    @GetMapping
    public ResponseEntity<List<String>> getAllCategoryNames() {
        return ResponseEntity.ok(categoryService.getAllCategoryNames());
    }

    @Operation(summary = "Get movies by category name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned list of movies for the given category"),
            @ApiResponse(responseCode = "404", description = "Category with the given name was not found")
    })
    @GetMapping("/{name}")
    public ResponseEntity<List<MovieResponse>> getMoviesByCategory(
            @Parameter(description = "The name of the category, e.g., 'Horror'") @PathVariable String name) {
        return categoryService.getMoviesByCategory(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}