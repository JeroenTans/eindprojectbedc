package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews ();

    Review getReview(Long id);

    Review saveReview(Review review);

    void deleteReview(Long id);

    Review addReview(ReviewRequest reviewRequest);

    List<Review> getReviewsByTipAmsterdamId (Long id);
}
