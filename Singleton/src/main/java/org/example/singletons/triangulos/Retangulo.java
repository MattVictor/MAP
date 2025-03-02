package org.example.singletons.triangulos;

import org.example.singletons.FiguraMethods;
import org.example.singletons.Triangulo;

import java.security.InvalidParameterException;

public class Retangulo extends Triangulo {

    private static Retangulo retangulo = null;

    private Retangulo(Double lado1, Double lado2, Double lado3) {
        super(lado1, lado2, lado3);
    }

    public static Retangulo getInstance(Double lado1, Double lado2, Double lado3) {
        if (validarRetangulo(lado1, lado2, lado3)) {
            if (retangulo == null) {
                retangulo = new Retangulo(lado1, lado2, lado3);
            }
        }
        return retangulo;
    }

    private static boolean validarRetangulo(double a, double b, double c) {
        double a2 = a*a;
        double b2 = b*b;
        double c2 = c*c;
        if (!(a2 == b2 + c2 || b2 == a2 + c2 || c2 == a2 + b2)) throw new InvalidParameterException("Lados inválidos para um triângulo retângulo.");
        return true;
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
        System.out.println("Triângulo Retângulo:");
        System.out.println("Lado1: " + lados[0]);
        System.out.println("Lado2: " + lados[1]);
        System.out.println("Lado3: " + lados[2]);
        System.out.println("Perimetro: " + calcularPerimetro());
        System.out.println("Area: " + calcularArea());
        System.out.println();
    }
}
