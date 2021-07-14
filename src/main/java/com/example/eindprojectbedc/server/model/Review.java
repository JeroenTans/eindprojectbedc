package com.example.eindprojectbedc.server.model;

import javax.persistence.*;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String address;

    @Column
    private String comment;

    @Column
    private Boolean heart;

    @Column
    private Boolean brokenHeart;

    @Column(name = "tip_amsterdam_id")
    private Long tipAmsterdamId;

    @ManyToOne
    @JoinColumn(name = "tip_amsterdam_id",insertable = false, updatable = false)
    private TipAmsterdam tipAmsterdam;

    public Review() {
    }

    public Review(String address, String comment, Boolean heart, Boolean brokenHeart) {
        this.address = address;
        this.comment = comment;
        this.heart = heart;
        this.brokenHeart = brokenHeart;
    }

    public Long getTipAmsterdamId() {
        return tipAmsterdamId;
    }
    public void setTipAmsterdamId(Long tipAmsterdamId) {
        this.tipAmsterdamId = tipAmsterdamId;
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
