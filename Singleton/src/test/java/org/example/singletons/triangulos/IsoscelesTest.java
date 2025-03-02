package org.example.singletons.triangulos;

import org.example.singletons.Triangulo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class IsoscelesTest {
    static Triangulo isosTest;

    @BeforeAll
    public static void setup(){
        isosTest = Triangulo.getInstance(Triangulo.Tipo.ISOSCELES,4.0,6.0,4.0);
    }

    @Test
    public void unicaInstancia(){
        assertThrows(InstantiationError.class, () -> Triangulo.getInstance(Triangulo.Tipo.ISOSCELES,6.0,6.0,6.0));
    }

    @Test
    public void naoEhUmTrianguloIsoceles(){
        assertThrows(InvalidParameterException.class, () -> Isosceles.getInstance(3.0,3.0,3.0));
    }

    @Test
    public void areaEquilatero(){
        assertEquals(7.93,isosTest.calcularArea(),0.01);
    }

    @Test
    public void perimetroEquilatero(){
        assertEquals(14.0,isosTest.calcularPerimetro(),0.0);
    }
}