package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.repository.ReviewRepository;
import com.example.eindprojectbedc.repository.TipAmsterdamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewServiceImpTest {

    @Mock
    ReviewRepository reviewRepository;

    @Mock
    TipAmsterdamRepository tipAmsterdamRepository;

    @InjectMocks
    private ReviewServiceImp reviewServiceImp;

    @BeforeEach
    public void setUp (){
        reviewServiceImp = new ReviewServiceImp(reviewRepository);
    }

    @Test
    public void testGetAllReviews(){
        when(reviewRepository.findAll()).thenReturn(List.of(new Review(), new Review()));
        List<Review> reviews = reviewServiceImp.getAllReviews();
        assertEquals(2, reviews.size());
    }

    @Test
    public void testGetReview(){
        Review review = new Review();
        review.setId(1L);
        Long id = review.getId();
        when(reviewRepository.findById(id)).thenReturn(Optional.of(review));
        Optional<Review> reviewOptional = Optional.ofNullable(reviewServiceImp.getReview(id));
        assertTrue(reviewOptional.isPresent());
        assertEquals(id, reviewOptional.get().getId());
    }

    @Test
    public void testSaveReview(){
        Long id = 3L;
        Review testReview = new Review();
        when(reviewRepository.save(testReview)).thenAnswer(inv -> {
            Review review1 = inv.getArgument(0);
            review1.setId(id);
            return review1;
        });
        Review created = reviewServiceImp.saveReview(testReview);
        assertEquals(3L, created.getId());
    }

    @Test
    public void testDeleteReview () {
        Review review = new Review();
        review.setId(1L);
        reviewServiceImp.deleteReview(review.getId());
        verify(reviewRepository).deleteById(review.getId());
    }

}