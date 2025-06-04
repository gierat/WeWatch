package com.tomaszgierat.wewatch_backend.service;

import com.tomaszgierat.wewatch_backend.dto.response.CarouselImageResponse;
import com.tomaszgierat.wewatch_backend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final MovieRepository movieRepository;

    public ResponseEntity<Resource> getImageFromFolder(String folder, String filename) throws IOException {
        Path filePath = Paths.get(folder).resolve(filename).normalize();
        Resource file = new UrlResource(filePath.toUri());

        if (!file.exists() || !file.isReadable()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(filePath))
                .body(file);
    }

    public List<CarouselImageResponse> getRecommendCarouselImages() throws IOException {
        Path folderPath = Paths.get("uploads/recommend_carousel");

        if (!Files.exists(folderPath) || !Files.isDirectory(folderPath)) {
            return List.of();
        }

        try (Stream<Path> paths = Files.list(folderPath)) {
            return paths
                    .filter(Files::isRegularFile)
                    .map(path -> {
                        String filename = path.getFileName().toString();
                        String baseName = filename.substring(0, filename.lastIndexOf('.'));
                        var movie = movieRepository.findByImagePathContainingIgnoreCase(baseName).orElse(null);
                        return new CarouselImageResponse(filename, movie != null ? movie.getId() : null);
                    })
                    .filter(img -> img.getMovieId() != null)
                    .sorted(java.util.Comparator.comparing(CarouselImageResponse::getFilename))
                    .collect(Collectors.toList());
        }
    }
}