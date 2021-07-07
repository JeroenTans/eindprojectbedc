package com.example.eindprojectbedc.ServiceIT;

import com.example.eindprojectbedc.ServiceTest.ReviewServiceImp;
import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.repository.ReviewRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReviewServiceIT {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewServiceImp reviewServiceImp;

    @AfterEach
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
        assertEquals(1, reviewList.size());
    }

    @Test
    public void itGetAllReviews(){
        Review review = new Review();
        review.setId(1L);
        review.setAddress("Zaagmolenstraat");
        review.setComment("erg mooi");
        reviewRepository.save(review);

        Review reviewTwo = new Review();
        reviewTwo.setId(1L);
        reviewTwo.setAddress("Zaagmolenstraat");
        reviewTwo.setComment("erg mooi");
        reviewRepository.save(reviewTwo);

        List<Review> reviewList = reviewRepository.findAll();
        assertEquals(2, reviewList.size());
    }

}
