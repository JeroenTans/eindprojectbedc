package com.example.eindprojectbedc.server.Service;

import com.example.eindprojectbedc.server.model.Review;
import com.example.eindprojectbedc.server.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class ReviewServiceIT {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewServiceImp reviewServiceImp;

    @BeforeEach
    public void deleteAll(){
        reviewRepository.deleteAll();
    }

    @Test
    public void itSaveReview(){
        Review review = new Review();
        review.setId(1L);
        review.setAddress("Zaagmolenstraat");
        review.setComment("erg mooi");
        reviewRepository.save(review);
        List<Review> reviewList = reviewServiceImp.getAllReviews();
        //ik heb al 15 ingebouwde reviews in mijn import.sql
        assertEquals(16, reviewList.size());
    }

    @Test
    public void itGetAllReviews(){
        Review review = new Review();
        review.setId(1L);
        review.setAddress("Zaagmolenstraat");
        review.setComment("erg mooi");
        reviewRepository.save(review);
        List<Review> reviewList = reviewRepository.findAll();
        //ik heb al 15 ingebouwde reviews in mijn import.sql
        assertEquals(16, reviewList.size());
    }

}
