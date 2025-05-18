package com.tomaszgierat.wewatch_backend.service;

import com.tomaszgierat.wewatch_backend.dto.request.CommentRequest;
import com.tomaszgierat.wewatch_backend.dto.response.CommentResponse;
import com.tomaszgierat.wewatch_backend.model.Comment;
import com.tomaszgierat.wewatch_backend.model.Movie;
import com.tomaszgierat.wewatch_backend.model.User;
import com.tomaszgierat.wewatch_backend.repository.CommentRepository;
import com.tomaszgierat.wewatch_backend.repository.MovieRepository;
import com.tomaszgierat.wewatch_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public void addComment(CommentRequest request) {
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Movie not found"));

        String email = ((UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getUsername();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "User not found"));

        Comment comment = Comment.builder()
                .movie(movie)
                .user(user)
                .content(request.getContent())
                .build();

        commentRepository.save(comment);
    }

    public List<CommentResponse> getCommentsForMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Movie not found"));

        return commentRepository.findByMovieOrderByCreatedAtDesc(movie).stream()
                .map(c -> CommentResponse.builder()
                        .id(c.getId())
                        .nickname(c.getUser().getNickname())
                        .content(c.getContent())
                        .createdAt(c.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
}