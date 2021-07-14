package com.example.eindprojectbedc.server.Service;

import com.example.eindprojectbedc.server.model.TipAmsterdam;
import com.example.eindprojectbedc.server.repository.TipAmsterdamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class TipAmsterdamIT {

    @Autowired
    private TipAmsterdamRepository tipAmsterdamRepository;

    @Autowired
    private TipAmsterdamServiceImp tipAmsterdamServiceImp;

    @BeforeEach
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
