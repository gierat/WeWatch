package com.tomaszgierat.wewatch_backend.service;

import com.tomaszgierat.wewatch_backend.dto.response.CarouselImageResponse;
import com.tomaszgierat.wewatch_backend.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
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