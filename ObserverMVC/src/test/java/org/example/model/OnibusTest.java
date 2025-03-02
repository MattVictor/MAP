package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OnibusTest {
    Onibus onibusTeste;

    @BeforeEach
    public void setup(){
        onibusTeste = new Onibus(9,"Varginha",new Date(2024,11,8),new Date(2024,12,25),52);
    }

    @Test
    public void getNumero(){
        assertEquals(9,onibusTeste.getNumero());
    }

    @Test
    public void getDestino(){
        assertEquals("Varginha",onibusTeste.getDestino());
    }

    @Test
    public void getChegada(){
        assertEquals(new Date(2024,11,8),onibusTeste.getChegada());
    }

    @Test
    public void getSaida(){
        assertEquals(new Date(2024,12,25),onibusTeste.getSaida());
    }

    @Test
    public void getNumAssento(){
        assertEquals(52,onibusTeste.getNumAssentos());
    }
}