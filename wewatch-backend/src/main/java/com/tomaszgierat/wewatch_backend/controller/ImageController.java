package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.dto.response.CarouselImageResponse;
import com.tomaszgierat.wewatch_backend.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @Operation(summary = "Get an image file related to a movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image returned successfully"),
            @ApiResponse(responseCode = "404", description = "Image not found")
    })
    @GetMapping("/movies/{filename:.+}")
    public ResponseEntity<Resource> getMovieImage(
            @Parameter(description = "Filename of the movie image, including extension")@PathVariable String filename) throws IOException {
        return imageService.getImageFromFolder("uploads/movies", filename);
    }

    @Operation(summary = "Get an image file from the slider")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image returned successfully"),
            @ApiResponse(responseCode = "404", description = "Image not found")
    })
    @GetMapping("/slider/{filename:.+}")
    public ResponseEntity<Resource> getSliderImage(
            @Parameter(description = "Filename of the slider image, including extension")@PathVariable String filename
    ) throws IOException {
        return imageService.getImageFromFolder("uploads/slider", filename);
    }

    @Operation(summary = "Get the list of carousel images linked to movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carousel image list returned successfully")
    })
    @GetMapping("/recommend_carousel")
    public ResponseEntity<List<CarouselImageResponse>> getCarouselImages() throws IOException {
        return ResponseEntity.ok(imageService.getRecommendCarouselImages());
    }

    @Operation(summary = "Get a single image from the recommendation carousel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Image returned successfully"),
            @ApiResponse(responseCode = "404", description = "Image not found")
    })
    @GetMapping("/recommend_carousel/{filename:.+}")
    public ResponseEntity<Resource> getRecommendCarouselImage(
            @Parameter(description = "Filename of the recommended carousel image, including extension")@PathVariable String filename
    ) throws IOException {
        return imageService.getImageFromFolder("uploads/recommend_carousel", filename);
    }
}