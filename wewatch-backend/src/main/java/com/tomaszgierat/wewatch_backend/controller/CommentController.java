package com.tomaszgierat.wewatch_backend.controller;

import com.tomaszgierat.wewatch_backend.dto.request.CommentRequest;
import com.tomaszgierat.wewatch_backend.dto.response.CommentResponse;
import com.tomaszgierat.wewatch_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Long movieId) {
        return ResponseEntity.ok(commentService.getCommentsForMovie(movieId));
    }

    @PostMapping
    public ResponseEntity<Void> addComment(@RequestBody CommentRequest request) {
        commentService.addComment(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

}