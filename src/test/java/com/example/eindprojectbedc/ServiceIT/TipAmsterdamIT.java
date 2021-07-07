package com.example.eindprojectbedc.ServiceIT;

import com.example.eindprojectbedc.ServiceTest.TipAmsterdamServiceImp;
import com.example.eindprojectbedc.model.TipAmsterdam;
import com.example.eindprojectbedc.repository.TipAmsterdamRepository;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TipAmsterdamIT {

    @Autowired
    private TipAmsterdamRepository tipAmsterdamRepository;

    @Autowired
    private TipAmsterdamServiceImp tipAmsterdamServiceImp;

    @AfterEach
    public void deleteAll(){
        tipAmsterdamRepository.deleteAll();
    }

    @Test
    public void itAddTipAmsterdam(){
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setId(1L);
        tipAmsterdam.setUsername("Jeroen");
        tipAmsterdam.setStandardTip(true);
        tipAmsterdam.setPrivateTip(false);
        tipAmsterdam.setPublicTip(false);
        tipAmsterdam.setPicturePath("MooieImage");
        tipAmsterdam.setExplanation("Wat een prachtige plek");
        tipAmsterdamRepository.save(tipAmsterdam);

        TipAmsterdam tipAmsterdamTwo = new TipAmsterdam();
        tipAmsterdamTwo.setId(1L);
        tipAmsterdamTwo.setUsername("Jeroen");
        tipAmsterdamTwo.setStandardTip(true);
        tipAmsterdamTwo.setPrivateTip(false);
        tipAmsterdamTwo.setPublicTip(false);
        tipAmsterdamTwo.setPicturePath("MooieImage");
        tipAmsterdamTwo.setExplanation("Wat een prachtige plek");
        tipAmsterdamRepository.save(tipAmsterdamTwo);

        List<TipAmsterdam> tipAmsterdamList = tipAmsterdamServiceImp.getAllTipsAmsterdam();
        assertEquals(2, tipAmsterdamList.size());
    }

//    @Test
//    public void itGetTipAmsterdam(){
//        TipAmsterdam tipAmsterdam = new TipAmsterdam();
//        tipAmsterdam.setId(1L);
//        tipAmsterdam.setUsername("Jeroen");
//        tipAmsterdam.setStandardTip(true);
//        tipAmsterdam.setPrivateTip(false);
//        tipAmsterdam.setPublicTip(false);
//        tipAmsterdam.setPicturePath("MooieImage");
//        tipAmsterdam.setExplanation("Wat een prachtige plek");
//        tipAmsterdamRepository.save(tipAmsterdam);
//        Optional<TipAmsterdam> found = Optional.of(tipAmsterdamServiceImp.getTipAmsterdam(tipAmsterdam.getId()));
//        assertTrue(found.isPresent());
//        assertEquals(tipAmsterdam, found.get());
//    }

    @Test
    public void itFilterTipByPublicTip(){
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setPublicTip(true);
        tipAmsterdamRepository.save(tipAmsterdam);
        List<Object> tipAmsterdamList = tipAmsterdamServiceImp.getAllPublicTipsAmsterdam();
        assertEquals(1, tipAmsterdamList.size());
    }

    @Test
    public void itFilterTipByPrivateTip(){
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setPrivateTip(true);
        tipAmsterdamRepository.save(tipAmsterdam);
        List<Object> tipAmsterdamList = tipAmsterdamServiceImp.getAllPrivateTipsAmsterdam();
        assertEquals(1, tipAmsterdamList.size());
    }

    @Test
    public void itFilterByStandardTip(){
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setStandardTip(true);
        tipAmsterdamRepository.save(tipAmsterdam);
        List<Object> tipAmsterdamList = tipAmsterdamServiceImp.getAllStandardTipsAmsterdam();
        assertEquals(1, tipAmsterdamList.size());
    }

    @Test
    public void itFilterByPrivateTipByUsername(){
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setUsername("Jan");
        tipAmsterdam.setPrivateTip(true);
        String username = tipAmsterdam.getUsername();
        tipAmsterdamRepository.save(tipAmsterdam);
        List<Object> tipAmsterdamList = tipAmsterdamServiceImp.getAllPrivateTipsAmsterdamByUsername(username);
        assertEquals(1, tipAmsterdamList.size());
    }

    @Test
    public void itFilterByPublicTipByUsername(){
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setUsername("Jan");
        tipAmsterdam.setPublicTip(true);
        String username = tipAmsterdam.getUsername();
        tipAmsterdamRepository.save(tipAmsterdam);
        List<Object> tipAmsterdamList = tipAmsterdamServiceImp.getAllPublicTipsAmsterdamByUsername(username);
        assertEquals(1, tipAmsterdamList.size());
    }

}
