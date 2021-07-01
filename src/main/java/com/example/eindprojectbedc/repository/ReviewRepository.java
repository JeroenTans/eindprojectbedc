package com.example.eindprojectbedc.repository;

import com.example.eindprojectbedc.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> getReviewByTipAmsterdamId(Long id);

}
