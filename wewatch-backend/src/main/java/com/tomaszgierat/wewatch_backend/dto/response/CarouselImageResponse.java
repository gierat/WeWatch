package com.tomaszgierat.wewatch_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarouselImageResponse {
    private String filename;
    private Long movieId;
}
