package com.jared.hngout.controller;
import com.jared.hngout.model.Review;
import com.jared.hngout.service.ReviewService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;

    }

    @PostMapping("/members/{memberId}/events/{eventId}")
    public ResponseEntity<Review> addReview(@PathVariable Long memberId,
                                            @PathVariable Long eventId, @RequestBody Review review) {
        Review created = reviewService.addReview(memberId, eventId, review);
        if (created == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/events/{eventId}")
    public ResponseEntity<List<Review>> getReviewsForEvent(@PathVariable Long eventId) {
        List<Review> reviews = reviewService.getReviewsForEvent(eventId);
        if (reviews == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reviews);
    }
}




