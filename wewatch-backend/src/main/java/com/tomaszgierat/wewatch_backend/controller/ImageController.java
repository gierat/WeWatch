package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.dto.response.CarouselImageResponse;
import com.tomaszgierat.wewatch_backend.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/movies/{filename:.+}")
    public ResponseEntity<Resource> getMovieImage(@PathVariable String filename) throws IOException {
        return imageService.getImageFromFolder("uploads/movies", filename);
    }

    @GetMapping("/slider/{filename:.+}")
    public ResponseEntity<Resource> getSliderImage(@PathVariable String filename) throws IOException {
        return imageService.getImageFromFolder("uploads/slider", filename);
    }

    @GetMapping("/recommend_carousel")
    public ResponseEntity<List<CarouselImageResponse>> getCarouselImages() throws IOException {
        return ResponseEntity.ok(imageService.getRecommendCarouselImages());
    }

    @GetMapping("/recommend_carousel/{filename:.+}")
    public ResponseEntity<Resource> getRecommendCarouselImage(@PathVariable String filename) throws IOException {
        return imageService.getImageFromFolder("uploads/recommend_carousel", filename);
    }
}