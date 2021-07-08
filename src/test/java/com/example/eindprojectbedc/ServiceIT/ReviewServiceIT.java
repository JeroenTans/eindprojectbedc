package com.example.eindprojectbedc.ServiceIT;

import com.example.eindprojectbedc.ServiceTest.ReviewServiceImp;
import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.repository.ReviewRepository;
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
        assertEquals(1, reviewList.size());
    }

    @Test
    public void itGetAllReviews(){
        Review review = new Review();
        review.setId(1L);
        review.setAddress("Zaagmolenstraat");
        review.setComment("erg mooi");
        reviewRepository.save(review);
        List<Review> reviewList = reviewRepository.findAll();
        assertEquals(1, reviewList.size());
    }

}
