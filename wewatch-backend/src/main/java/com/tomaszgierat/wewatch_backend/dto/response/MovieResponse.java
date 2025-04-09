package com.tomaszgierat.wewatch_backend.dto.response;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {
    private Long id;
    private String title;
    private String description;
    private String imagePath;
    private List<String> categories;
}