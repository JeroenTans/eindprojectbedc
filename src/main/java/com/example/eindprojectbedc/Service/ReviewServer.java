package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.exception.RecourceNotFoundException;
import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReviewServer {

    @Autowired
    private ReviewRepository reviewRepository;

    public Collection<Review> getReview(){
        return reviewRepository.findAll();
    }

    public Review createReview (@RequestBody Review review){
        return reviewRepository.save(review);
    }

    public Map<String, Boolean> deleteReview (@PathVariable Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()-> new RecourceNotFoundException("Review bestaat niet onder id: " + id));

        reviewRepository.delete(review);
        Map<String, Boolean> response = new HashMap<>();
        response.put("verwijderd", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }

}
