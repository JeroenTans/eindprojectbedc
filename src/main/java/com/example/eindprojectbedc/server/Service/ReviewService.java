package com.example.eindprojectbedc.server.Service;

import com.example.eindprojectbedc.server.model.Review;
import com.example.eindprojectbedc.server.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews ();
    Review getReview(Long id);
    Review saveReview(Review review);
    void deleteReview(Long id);
    Review addReview(ReviewRequest reviewRequest);
    List<Review> getReviewsByTipAmsterdamId (Long id);
}
