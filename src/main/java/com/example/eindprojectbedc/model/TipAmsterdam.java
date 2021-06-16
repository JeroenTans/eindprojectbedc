package com.example.eindprojectbedc.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "TipAmsterdam")
public class TipAmsterdam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String picturePath;

    private String address;

    private String explanation;

    private boolean isPrivateTip;

    private boolean isPublicTip;

    private boolean isStandardTip;

    public TipAmsterdam() {
    }

    public TipAmsterdam(String address, String explanation, String picturePath, boolean isStandardTip, boolean isPublicTip, boolean isPrivateTip) {
        this.address = address;
        this.explanation = explanation;
        this.picturePath = picturePath;
        this.isStandardTip = isStandardTip;
        this.isPublicTip = isPublicTip;
        this.isPrivateTip = isPrivateTip;
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
