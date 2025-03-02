package org.example.singletons;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {
    static Circulo circuloTeste;

    @BeforeAll
    public static void setup(){
        circuloTeste = Circulo.getInstance(3.0);
    }

    @Test
    public void unicaInstancia(){
        assertThrows(InstantiationError.class, () -> Circulo.getInstance(8.0));
    }

    @Test
    public void raioNegativo(){
        assertThrows(InvalidParameterException.class, () -> Circulo.getInstance(-1.0));
    }

    @Test
    public void raioZero(){
        assertThrows(InvalidParameterException.class, () -> Circulo.getInstance(0.0));
    }

    @Test
    public void areaDoCirculo(){
        assertEquals(28.27,circuloTeste.calcularArea(),0.01);
    }

    @Test
    public void perimetroDoCirculo(){
        assertEquals(18.84,circuloTeste.calcularPerimetro(), 0.01);
    }
}