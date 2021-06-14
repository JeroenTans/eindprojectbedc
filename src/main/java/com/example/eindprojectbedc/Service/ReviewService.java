package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews ();

    Review getReview(Long id);

    Review saveReview(Review review);

    void deleteReview(Long id);

}
