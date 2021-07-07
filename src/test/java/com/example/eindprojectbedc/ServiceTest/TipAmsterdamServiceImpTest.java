package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.model.TipAmsterdam;
import com.example.eindprojectbedc.repository.TipAmsterdamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    @BeforeEach
    public void setup() {
        tipAmsterdamServiceImp = new TipAmsterdamServiceImp(tipAmsterdamRepository);
    }

    @Test
    public void testGetAllTipsAmsterdam(){
        when(tipAmsterdamRepository.findAll()).thenReturn(List.of(new TipAmsterdam(), new TipAmsterdam()));
        List<TipAmsterdam> tipAmsterdamList = tipAmsterdamServiceImp.getAllTipsAmsterdam();
        assertEquals(2, tipAmsterdamList.size());
    }

    @Test
    public void testGetTipAmsterdam(){
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setId(1L);
        Long id = tipAmsterdam.getId();
        when(tipAmsterdamRepository.findById(id)).thenReturn(Optional.of(tipAmsterdam));
        Optional<TipAmsterdam> tipAmsterdamOptional = Optional.ofNullable(tipAmsterdamServiceImp.getTipAmsterdam(id));
        assertTrue(tipAmsterdamOptional.isPresent());
        assertEquals(id, tipAmsterdamOptional.get().getId());
    }

    @Test
    public void testAddTipAmsterdam(){
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
    public void deleteTipAmsterdam(){
        TipAmsterdam tipAmsterdam = new TipAmsterdam();
        tipAmsterdam.setId(1L);
        tipAmsterdamServiceImp.deleteTipAmsterdam(tipAmsterdam.getId());
        verify(tipAmsterdamRepository).deleteById(tipAmsterdam.getId());
    }

}