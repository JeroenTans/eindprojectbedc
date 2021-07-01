package com.example.eindprojectbedc.controller.dto;

import com.example.eindprojectbedc.model.Review;
import com.example.eindprojectbedc.model.TipAmsterdam;

public class ReviewInputDto {

    public String address;
    public String comment;
    public boolean heart;
    public boolean brokenHeart;
//    public TipAmsterdam tipAmsterdam;

    public Review toReview(){
        var review = new Review();
        review.setAddress(address);
        review.setComment(comment);
        review.setHeart(heart);
        review.setBrokenHeart(brokenHeart);
//        review.setTipAmsterdam(tipAmsterdam);
        return review;
    }
}
