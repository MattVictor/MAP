package org.example.singletons.triangulos;

import org.example.singletons.Triangulo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class RetanguloTest {
    static Triangulo retanTest;

    @BeforeAll
    public static void setup(){
        retanTest = Triangulo.getInstance(Triangulo.Tipo.RETANGULO,10.0,6.0,8.0);
    }

    @Test
    public void unicaInstancia(){
        assertThrows(InstantiationError.class, () -> Triangulo.getInstance(Triangulo.Tipo.RETANGULO,15.0,12.0,9.0));
    }

    @Test
    public void naoEhUmTrianguloRetangulo(){
        assertThrows(InvalidParameterException.class, () -> Retangulo.getInstance(3.0,4.0,3.0));
    }

    @Test
    public void areaEquilatero(){
        assertEquals(24.0,retanTest.calcularArea(),0.01);
    }

    @Test
    public void perimetroEquilatero(){
        assertEquals(24.0,retanTest.calcularPerimetro(),0.0);
    }
}