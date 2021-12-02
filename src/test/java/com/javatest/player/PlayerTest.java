package com.javatest.player;

import org.junit.Test;

import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void looses_when_dice_number_is_too_low() {
        Dice dice =  Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);
        //usamos la libreria mokito
        Player playerer = new Player(dice, 3);
        assertEquals(false, playerer.play());
    }
    @Test
    public void wins_when_dice_number_is_big() {
        Dice dice =  Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);
        //usamos la libreria mokito
        Player playerer = new Player(dice, 3);
        assertTrue(playerer.play());
        //assert simplificado
    }

}