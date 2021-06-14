package com.example.eindprojectbedc.model;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    private String comment;

    private Boolean heart;

    private Boolean brokenHeart;

    public Review() {
    }

    public Review(String address, String comment, Boolean heart, Boolean brokenHeart) {
        this.address = address;
        this.comment = comment;
        this.heart = heart;
        this.brokenHeart = brokenHeart;
    }

    public Boolean getBrokenHeart() {
        return brokenHeart;
    }
    public void setBrokenHeart(Boolean brokenHeart) {
        this.brokenHeart = brokenHeart;
    }
    public Boolean getHeart() {
        return heart;
    }
    public void setHeart(Boolean heart) {
        this.heart = heart;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
