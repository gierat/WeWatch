package com.tomaszgierat.wewatch_backend.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/api/images")
@CrossOrigin("*")
public class ImageController {

    @GetMapping("/movies/{filename:.+}")
    public ResponseEntity<Resource> getMovieImage(@PathVariable String filename) throws IOException {
        Path filePath = Paths.get("uploads/movies").resolve(filename).normalize();
        Resource file = new UrlResource(filePath.toUri());

        if (!file.exists() || !file.isReadable()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(filePath))
                .body(file);
    }

    @GetMapping("/slider/{filename:.+}")
    public ResponseEntity<Resource> getSliderImage(@PathVariable String filename) throws IOException {
        Path filePath = Paths.get("uploads/slider").resolve(filename).normalize();
        Resource file = new UrlResource(filePath.toUri());

        if (!file.exists() || !file.isReadable()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(filePath))
                .body(file);
    }
}
