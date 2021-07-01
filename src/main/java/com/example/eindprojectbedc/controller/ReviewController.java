package com.example.eindprojectbedc.controller;

import com.example.eindprojectbedc.Service.ReviewService;
import com.example.eindprojectbedc.Service.TipAmsterdamService;
import com.example.eindprojectbedc.controller.dto.ReviewDto;
import com.example.eindprojectbedc.controller.dto.ReviewInputDto;
import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.model.TipAmsterdam;
import com.example.eindprojectbedc.repository.TipAmsterdamRepository;
import com.example.eindprojectbedc.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private TipAmsterdamService tipAmsterdamService;
    private TipAmsterdamRepository tipAmsterdamRepository;

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

    @DeleteMapping({"{id}"})
    public ResponseEntity<Object> deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/reviews")
//    public Review getReviewsOfTips(@PathVariable("id") Long id) {
//        return tipAmsterdamService.getTipAmsterdamById(id).
//    }

    @GetMapping("/{id}")
    public ReviewDto getReview(@PathVariable("id") Long id) {
        var review = reviewService.getReview(id);
        return ReviewDto.fromReview(review);
    }
//
//    @GetMapping
//    public List<ReviewDto> getAllReviews() {
//        var dtos = new ArrayList<ReviewDto>();
//        var allReviews = reviewService.getAllReviews();
//
//        for (Review review : allReviews) {
//            dtos.add(ReviewDto.fromReview(review));
//        }
//        return dtos;
//    }

    @GetMapping("{id}/reviews")
    public List<Review> getReviewsByTipAmsterdamId(@PathVariable("id") Long tipAmsterdamId) {
        return reviewService.getReviewsByTipAmsterdamId(tipAmsterdamId);
    }

    @PostMapping
    public ReviewDto saveReview(@RequestBody ReviewInputDto dto) {
        var review = reviewService.saveReview(dto.toReview());
        return ReviewDto.fromReview(review);
    }

    @PostMapping("savereview")
    public Review addReview (@RequestBody ReviewRequest reviewRequest){
        return reviewService.addReview(reviewRequest);
    }

//    @PostMapping("/review")
//    public ResponseEntity<Object> addReview(@RequestParam String address,
//                                            @RequestParam Boolean brokenHeart,
//                                            @RequestParam String comment,
//                                            @RequestParam Boolean heart,
//                                            @RequestParam Long tipAmsterdamId) {
//        try {
//            TipAmsterdam tipAmsterdam = tipAmsterdamRepository.getById(tipAmsterdamId);
//            Review review = new Review();
//            review.setTipAmsterdam(tipAmsterdam);
//            review.setBrokenHeart(brokenHeart);
//            review.setHeart(heart);
//            review.setComment(comment);
//            review.setAddress(address);
//
//            reviewService.saveReview(review);
//            return ResponseEntity.noContent().build();
//        } catch (Exception exception) {
//            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
//        }
//    }
}
