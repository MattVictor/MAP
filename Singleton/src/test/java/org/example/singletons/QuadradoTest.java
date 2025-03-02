package org.example.singletons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class QuadradoTest {
    Quadrado quadradoTeste;

    @BeforeEach
    public void setup(){
        this.quadradoTeste = new Quadrado(4.16);
    }

    @Test
    public void multiplasInstancias(){
        new Quadrado(10.0);
        new Quadrado(15.3);
        new Quadrado(7.8);
    }

    @Test
    public void ladoNegativo(){
        assertThrows(InvalidParameterException.class, () -> new Quadrado(-6.4));
    }

    @Test
    public void ladoZero(){
        assertThrows(InvalidParameterException.class, () -> new Quadrado(0.0));
    }

    @Test
    public void calcularArea(){
        assertEquals(17.30, quadradoTeste.calcularArea(), 0.01);
    }

    @Test
    public void calcularPerimetro(){
        assertEquals(16.64, quadradoTeste.calcularPerimetro(),0.0);
    }
}