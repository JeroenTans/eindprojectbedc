package com.example.eindprojectbedc.controller;

import com.example.eindprojectbedc.Service.ReviewService;
import com.example.eindprojectbedc.controller.dto.ReviewDto;
import com.example.eindprojectbedc.controller.dto.ReviewInputDto;
import com.example.eindprojectbedc.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<ReviewDto> getAllReviews() {
        var dtos = new ArrayList<ReviewDto>();
        var allReviews = reviewService.getAllReviews();

        for (Review review : allReviews) {
            dtos.add(ReviewDto.fromReview(review));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public ReviewDto getReview(@PathVariable("id") Long id) {
        var review = reviewService.getReview(id);
        return ReviewDto.fromReview(review);
    }

    @PostMapping
    public ReviewDto saveReview(@RequestBody ReviewInputDto dto) {
        var review = reviewService.saveReview(dto.toReview());
        return ReviewDto.fromReview(review);
    }
}
