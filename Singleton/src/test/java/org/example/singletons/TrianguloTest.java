package org.example.singletons;

import org.example.singletons.triangulos.Equilatero;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrianguloTest {
    @Test
    public void ladoNegativo(){
        assertThrows(InvalidParameterException.class, () -> Triangulo.getInstance(Triangulo.Tipo.EQUILATERO,-1.0, 5.0, 10.0));
    }

    @Test
    public void ladoZero(){
        assertThrows(InvalidParameterException.class, () -> Triangulo.getInstance(Triangulo.Tipo.ISOSCELES, 3.0, 0.0, 2.0));
    }

    @Test
    public void naoTriangulo(){
        assertThrows(InvalidParameterException.class, () -> Triangulo.getInstance(Triangulo.Tipo.RETANGULO, 2.0, 5.0, 2.5));
    }
}
