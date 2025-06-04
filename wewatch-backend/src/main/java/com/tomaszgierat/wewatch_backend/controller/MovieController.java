package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.dto.response.MovieResponse;
import com.tomaszgierat.wewatch_backend.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MovieController {

    private final MovieService movieService;

    @Operation(summary = "Get comments for a movie", description = "Returns all comments for a given movie ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned comments"),
            @ApiResponse(responseCode = "404", description = "Movie not found"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(
            @Parameter(description = "The ID of the movie to retrieve", example = "1")
            @PathVariable Long id) {
        return movieService.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Get all movies",
            description = "Returns a list of movies (limited to the first 8 in ascending order by ID)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned list of movies")
    })
    @GetMapping
    public List<MovieResponse> getAllMovies() {
        return movieService.getAllMovies();
    }
}