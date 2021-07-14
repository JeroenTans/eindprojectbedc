package com.example.eindprojectbedc.server.controller;

import com.example.eindprojectbedc.server.Service.ReviewService;
import com.example.eindprojectbedc.server.model.Review;
import com.example.eindprojectbedc.server.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        var reviews = new ArrayList<Review>();
        var allReviews = reviewService.getAllReviews();

        for (Review review : allReviews) {
            reviews.add(review);
        }
        return reviews;
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable("id") Long id) {
        var review = reviewService.getReview(id);
        return review;
    }

    @GetMapping("{id}/reviews")
    public List<Review> getReviewsByTipAmsterdamId(@PathVariable("id") Long tipAmsterdamId) {
        return reviewService.getReviewsByTipAmsterdamId(tipAmsterdamId);
    }

    @PostMapping
    public Review saveReview(@RequestBody Review reviewOne) {
        var review = reviewService.saveReview(reviewOne);
        return review;
    }

    @PostMapping("savereview")
    public Review addReview (@RequestBody ReviewRequest reviewRequest){
        return reviewService.addReview(reviewRequest);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Object> deleteReview(@PathVariable("id") Long id) throws IOException {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

}
