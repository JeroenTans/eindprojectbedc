package com.example.eindprojectbedc.controller.dto;

import com.example.eindprojectbedc.model.TipAmsterdam;

public class TipAmsterdamInputDto {

    public String address;
    public String explanation;
    public boolean isPrivateTip;
    public boolean isPublicTip;
    public boolean isStandardTip;
    byte[] picturePath;

    public TipAmsterdam toTipAmsterdam(){
        var tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setAddress(address);
        tipAmsterdam.setExplanation(explanation);
        tipAmsterdam.setPrivateTip(isPrivateTip);
        tipAmsterdam.setPublicTip(isPublicTip);
        tipAmsterdam.setStandardTip(isStandardTip);
        tipAmsterdam.setPicturePath(picturePath);
        return tipAmsterdam;
    }
}
