package org.example.singletons;

import org.example.singletons.triangulos.Equilatero;
import org.example.singletons.triangulos.Isosceles;
import org.example.singletons.triangulos.Retangulo;

import java.security.InvalidParameterException;

public abstract class Triangulo implements FiguraMethods {

    public enum Tipo {EQUILATERO,ISOSCELES,RETANGULO}

    private static Equilatero equilatero = null;
    private static Isosceles isosceles = null;
    private static Retangulo retangulo = null;

    private static final Triangulo[] triangulos = new Triangulo[3];

    protected Double[] lados;

    protected Triangulo(Double lado1, Double lado2, Double lado3) {
        lados = new Double[]{lado1, lado2, lado3};
    }

    public static Triangulo getInstance(Tipo tipo, Double lado1, Double lado2, Double lado3) {
        if(validarLados(lado1, lado2, lado3)) {
            switch (tipo) {
                case EQUILATERO:
                    if (equilatero == null) {
                        equilatero = Equilatero.getInstance(lado1, lado2, lado3);
                        triangulos[tipo.ordinal()] = equilatero;
                    } else {
                        throw new InstantiationError("Triângulo Equilátero já foi instanciado.");
                    }
                    break;

                case ISOSCELES:
                    if (isosceles == null) {
                        isosceles = Isosceles.getInstance(lado1, lado2, lado3);
                        triangulos[tipo.ordinal()] = isosceles;
                    } else {
                        throw new InstantiationError("Triângulo Isósceles já foi instanciado.");
                    }
                    break;

                case RETANGULO:
                    if (retangulo == null) {
                        retangulo = Retangulo.getInstance(lado1, lado2, lado3);
                        triangulos[tipo.ordinal()] = retangulo;
                    } else {
                        throw new InstantiationError("Triângulo Retângulo já foi instanciado.");
                    }
            }
        }

        return triangulos[tipo.ordinal()];
    }

    public static Triangulo getInstance(Tipo tipo) {
        return triangulos[tipo.ordinal()];
    }

    private static boolean validarLados(Double a, Double b, Double c) {
        if (a + b <= c || a + c <= b || b + c <= a) throw new InvalidParameterException("Lados invalidos pela Desigualdade Triangular.");
        if (a <= 0 || b <= 0 || c <= 0) throw new InvalidParameterException("Lados invalidos. Valores negativos para medidas geométricas.");
        return true;
    }

    public abstract void setLados(Double lado1, Double lado2, Double lado3);

    public abstract Double[] getLados();
}
