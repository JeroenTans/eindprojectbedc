package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.exception.NotFoundException;
import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService{

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImp(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReview(Long id) {
        var optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            return optionalReview.get();
        } else throw new NotFoundException();
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
