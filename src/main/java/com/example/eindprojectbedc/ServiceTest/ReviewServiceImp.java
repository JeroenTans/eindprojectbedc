package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.exception.NotFoundException;
import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.model.TipAmsterdam;
import com.example.eindprojectbedc.repository.ReviewRepository;
import com.example.eindprojectbedc.repository.TipAmsterdamRepository;
import com.example.eindprojectbedc.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService{

    private ReviewRepository reviewRepository;
    @Autowired
    private TipAmsterdamRepository tipAmsterdamRepository;

    @Autowired
    public ReviewServiceImp(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Object> getAllReviewsByTipAmsterdamId(Long id) {
        List<Review> reviewList = reviewRepository.findAll();
        List<Object> reviewByTips = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getTipAmsterdamId()==id) reviewByTips.add(reviewList.get(i));
        }
        return reviewByTips;
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

    public Review addReview(ReviewRequest reviewRequest) {
        TipAmsterdam tipAmsterdam = tipAmsterdamRepository.findTipAmsterdamById(reviewRequest.tipAmsterdamId);

        Review review = new Review();
        review.setAddress(reviewRequest.address);
        review.setComment(reviewRequest.comment);
        review.setHeart(reviewRequest.heart);
        review.setBrokenHeart(reviewRequest.brokenHeart);
        review.setTipAmsterdamId(reviewRequest.tipAmsterdamId);

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByTipAmsterdamId(Long id) {
        return reviewRepository.getReviewByTipAmsterdamId(id);
    }
}
