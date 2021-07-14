package com.example.eindprojectbedc.server.controller.dto;

import com.example.eindprojectbedc.server.model.Review;

public class ReviewDto {

    public long id;
    public String address;
    public String comment;
    public boolean heart;
    public boolean brokenHeart;
    public Long tipAmsterdamId;

    public static ReviewDto fromReview(Review review) {
        var dto = new ReviewDto();
        dto.id = review.getId();
        dto.address = review.getAddress();
        dto.comment = review.getComment();
        dto.heart = review.getHeart();
        dto.brokenHeart = review.getBrokenHeart();
        dto.tipAmsterdamId = review.getTipAmsterdamId();
        return dto;
    }
}
