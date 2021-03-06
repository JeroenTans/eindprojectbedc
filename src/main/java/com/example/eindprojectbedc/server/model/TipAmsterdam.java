package com.example.eindprojectbedc.server.model;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "tipAmsterdams")
public class TipAmsterdam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
    private String picturePath;

    @Column
    private String address;

    @Column
    private String explanation;

    @Column
    private String groupName;

    @Column
    private boolean isPrivateTip;

    @Column
    private boolean isPublicTip;

    @Column
    private boolean isStandardTip;

    @Column
    private boolean isGroupTip = false;

    @Column
    private boolean receivedTip = false;

    @Column
    private boolean sendTip;

    @OneToMany(mappedBy = "tipAmsterdam",
            targetEntity = com.example.eindprojectbedc.server.model.Review.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Review> reviews;

    public TipAmsterdam() {
    }
    public TipAmsterdam(boolean isGroupTip, String address, String explanation, String picturePath, boolean isStandardTip, boolean isPublicTip, boolean isPrivateTip) {
        this.address = address;
        this.explanation = explanation;
        this.picturePath = picturePath;
        this.isStandardTip = isStandardTip;
        this.isPublicTip = isPublicTip;
        this.isPrivateTip = isPrivateTip;
        this.isGroupTip = isGroupTip;
    }

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public boolean isGroupTip() {
        return isGroupTip;
    }
    public void setGroupTip(boolean groupTip) {
        isGroupTip = groupTip;
    }
    public boolean isSendTip() {
        return sendTip;
    }
    public void setSendTip(boolean sendTip) {
        this.sendTip = sendTip;
    }
    public boolean isReceivedTip() {
        return receivedTip;
    }
    public void setReceivedTip(boolean receivedTip) {
        this.receivedTip = receivedTip;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public boolean isStandardTip() {
        return isStandardTip;
    }
    public void setStandardTip(boolean standardTip) {
        isStandardTip = standardTip;
    }
    public boolean isPublicTip() {
        return isPublicTip;
    }
    public void setPublicTip(boolean publicTip) {
        isPublicTip = publicTip;
    }
    public boolean isPrivateTip() {
        return isPrivateTip;
    }
    public void setPrivateTip(boolean privateTip) {
        isPrivateTip = privateTip;
    }
    public String getPicturePath() {
        return picturePath;
    }
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
    public String getExplanation() {
        return explanation;
    }
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
