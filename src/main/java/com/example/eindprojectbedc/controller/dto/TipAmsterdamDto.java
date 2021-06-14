package com.example.eindprojectbedc.controller.dto;

import com.example.eindprojectbedc.model.TipAmsterdam;

public class TipAmsterdamDto {

    public long id;
    public String address;
    public String explanation;
    public boolean isPrivateTip;
    public boolean isPublicTip;
    public boolean isStandardTip;

    public static TipAmsterdamDto fromTipAmsterdam (TipAmsterdam tipAmsterdam) {
        var dto = new TipAmsterdamDto();
        dto.id = tipAmsterdam.getId();
        dto.address = tipAmsterdam.getAddress();
        dto.explanation = tipAmsterdam.getExplanation();
        dto.isPrivateTip = tipAmsterdam.isPrivateTip();
        dto.isPublicTip = tipAmsterdam.isPublicTip();
        dto.isStandardTip = tipAmsterdam.isStandardTip();
        return dto;
    }
}
