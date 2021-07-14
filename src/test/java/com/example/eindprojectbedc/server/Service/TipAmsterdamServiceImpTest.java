package com.example.eindprojectbedc.server.Service;

import com.example.eindprojectbedc.server.exception.IdNotFoundException;
import com.example.eindprojectbedc.server.model.TipAmsterdam;
import com.example.eindprojectbedc.server.model.User;
import com.example.eindprojectbedc.server.repository.TipAmsterdamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TipAmsterdamServiceImpTest {

    @Mock
    TipAmsterdamRepository tipAmsterdamRepository;

    @InjectMocks
    private TipAmsterdamServiceImp tipAmsterdamServiceImp;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @BeforeEach
    public void setup() {
        tipAmsterdamServiceImp = new TipAmsterdamServiceImp(tipAmsterdamRepository);
    }

    @Test
    public void testGetAllTipsAmsterdam() {
        when(tipAmsterdamRepository.findAll()).thenReturn(List.of(new TipAmsterdam(), new TipAmsterdam()));
        List<TipAmsterdam> tipAmsterdamList = tipAmsterdamServiceImp.getAllTipsAmsterdam();
        assertEquals(2, tipAmsterdamList.size());
    }

    @Test
    public void testGetAllPublicTipsAmsterdam(){
        TipAmsterdam tipAmsterdamOne = new TipAmsterdam();
        TipAmsterdam tipAmsterdamTwo = new TipAmsterdam();
        tipAmsterdamOne.setPublicTip(true);
        tipAmsterdamTwo.setPublicTip(true);
        when(tipAmsterdamServiceImp.getAllPublicTipsAmsterdam()).thenReturn(List.of(tipAmsterdamOne, tipAmsterdamTwo));
        List<Object> tipAmsterdamList = tipAmsterdamServiceImp.getAllPublicTipsAmsterdam();
        assertEquals(2, tipAmsterdamList.size());
    }

    @Test
    public void testGetAllPrivateTipsAmsterdam(){
        TipAmsterdam tipAmsterdamOne = new TipAmsterdam();
        TipAmsterdam tipAmsterdamTwo = new TipAmsterdam();
        tipAmsterdamOne.setPrivateTip(true);
        tipAmsterdamTwo.setPrivateTip(true);
        when(tipAmsterdamServiceImp.getAllPrivateTipsAmsterdam()).thenReturn(List.of(tipAmsterdamOne,tipAmsterdamTwo));
        List<Object> tipAmsterdamList = tipAmsterdamServiceImp.getAllPrivateTipsAmsterdam();
        assertEquals(2, tipAmsterdamList.size());
    }

    @Test
    public void testGetAllStandardTipsAmsterdam(){
        TipAmsterdam tipAmsterdamOne = new TipAmsterdam();
        TipAmsterdam tipAmsterdamTwo = new TipAmsterdam();
        tipAmsterdamOne.setStandardTip(true);
        tipAmsterdamTwo.setStandardTip(true);
        when(tipAmsterdamServiceImp.getAllStandardTipsAmsterdam()).thenReturn(List.of(tipAmsterdamOne, tipAmsterdamTwo));
        List<Object> tipAmsterdamList = tipAmsterdamServiceImp.getAllStandardTipsAmsterdam();
        assertEquals(2, tipAmsterdamList.size());
    }

    @Test
    public void testGetTipAmsterdam() {
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setId(1L);
        Long id = tipAmsterdam.getId();
        when(tipAmsterdamRepository.findById(id)).thenReturn(Optional.of(tipAmsterdam));
        Optional<TipAmsterdam> tipAmsterdamOptional = Optional.ofNullable(tipAmsterdamServiceImp.getTipAmsterdam(id));
        assertTrue(tipAmsterdamOptional.isPresent());
        assertEquals(id, tipAmsterdamOptional.get().getId());
    }

    @Test
    public void testAddTipAmsterdam() {
        Long id = 3L;
        TipAmsterdam testTipAmsterdam = new TipAmsterdam();
        when(tipAmsterdamRepository.save(testTipAmsterdam)).thenAnswer(inv -> {
            TipAmsterdam tipAmsterdam1 = inv.getArgument(0);
            tipAmsterdam1.setId(id);
            return tipAmsterdam1;
        });
        TipAmsterdam created = tipAmsterdamServiceImp.addTipAmsterdam(testTipAmsterdam);
        assertEquals(3L, created.getId());
    }

    @Test
    public void deleteTipAmsterdam() {
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setId(1L);
        tipAmsterdamServiceImp.deleteTipAmsterdam(tipAmsterdam.getId());
        verify(tipAmsterdamRepository).deleteById(tipAmsterdam.getId());
    }

    @Test
    public void testGetTipAmsterdamById2(){
        TipAmsterdam tipAmsterdamTest = new TipAmsterdam();
        tipAmsterdamTest.setId(1L);
        when(tipAmsterdamRepository.existsById(tipAmsterdamTest.getId())).thenReturn(false);
        assertThrows(IdNotFoundException.class, ()->{tipAmsterdamServiceImp.getTipAmsterdamById(tipAmsterdamTest.getId());});
    }
}
