package com.example.eindprojectbedc.controller;

import com.example.eindprojectbedc.Service.ReviewServer;
import com.example.eindprojectbedc.exception.RecourceNotFoundException;
import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewServer reviewServer;

    @GetMapping("/get_reviews")
    public ResponseEntity<Object> getReviews(){
        return ResponseEntity.ok().body(reviewServer.getReview());
    }

    @PostMapping("/post_reviews")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok().body(reviewServer.createReview(review));
    }

    @DeleteMapping("/delete_tips/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReview(@PathVariable Long id) {
        return ResponseEntity.ok(reviewServer.deleteReview(id));
    }

}
