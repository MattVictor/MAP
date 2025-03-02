package org.example.singletons.triangulos;

import org.example.singletons.Triangulo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class EquilateroTest {
    static Triangulo equilTest;

    @BeforeAll
    public static void setup(){
        equilTest = Triangulo.getInstance(Triangulo.Tipo.EQUILATERO,4.0,4.0,4.0);
    }

    @Test
    public void unicaInstancia(){
        assertThrows(InstantiationError.class, () -> Triangulo.getInstance(Triangulo.Tipo.EQUILATERO,6.0,6.0,6.0));
    }

    @Test
    public void naoEhUmTrianguloEquilatero(){
        assertThrows(InvalidParameterException.class, () -> Equilatero.getInstance(3.0,4.0,3.0));
    }

    @Test
    public void areaEquilatero(){
        assertEquals(6.92,equilTest.calcularArea(),0.01);
    }

    @Test
    public void perimetroEquilatero(){
        assertEquals(12.0,equilTest.calcularPerimetro(),0.0);
    }
}