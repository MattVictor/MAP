package org.example.singletons.triangulos;

import org.example.singletons.FiguraMethods;
import org.example.singletons.Triangulo;

import java.security.InvalidParameterException;

public class Isosceles extends Triangulo {

    private static Isosceles isosceles = null;

    private Isosceles(Double lado1, Double lado2, Double lado3) {
        super(lado1, lado2, lado3);
    }

    public static Isosceles getInstance(Double lado1, Double lado2, Double lado3) {
        if (validarIsosceles(lado1, lado2, lado3)) {
            if (isosceles == null) {
                isosceles = new Isosceles(lado1, lado2, lado3);
            }
        }
        return isosceles;
    }

    private static boolean validarIsosceles(double a, double b, double c) {
        if ((a == b && a != c) || (a == c && a != b) || (b == c && b!= a))
            return true;
        else
            throw new InvalidParameterException("Lados inválidos para um triângulo isosceles.");
    }

    @Override
    public void setLados(Double lado1, Double lado2, Double lado3) {
        lados = new Double[]{lado1, lado2, lado3};
    }

    @Override
    public Double[] getLados() {
        return this.lados;
    }

    @Override
    public Double calcularArea() {
        Double a = lados[0];
        Double b = lados[1];
        Double c = lados[2];
        Double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public Double calcularPerimetro() {
        Double soma = 0.0;
        for (Double lado : lados) {
            soma += lado;
        }
        return soma;
    }

    @Override
    public void printarDados() {
        System.out.println("Triângulo Isósceles:");
        System.out.println("Lado1: " + lados[0]);
        System.out.println("Lado2: " + lados[1]);
        System.out.println("Lado3: " + lados[2]);
        System.out.println("Perimetro: " + calcularPerimetro());
        System.out.println("Area: " + calcularArea());
        System.out.println();
    }
}
