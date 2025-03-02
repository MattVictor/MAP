package org.example.singletons.triangulos;

import org.example.singletons.Triangulo;

import java.security.InvalidParameterException;

public class Equilatero extends Triangulo {

    private static Equilatero equilatero = null;

    private Equilatero(Double lado1, Double lado2, Double lado3) {
        super(lado1, lado2, lado3);
    }

    public static Equilatero getInstance(Double lado1, Double lado2, Double lado3) {
        if(validarEquilatero(lado1, lado2, lado3)) {
            if (equilatero == null) {
                equilatero = new Equilatero(lado1, lado2, lado3);
            }
        }
        return equilatero;
    }

    private static boolean validarEquilatero(double a, double b, double c) {
        if (!(a == b && a == c)) throw new InvalidParameterException("Lados inválidos para um triângulo equilátero.");
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
        System.out.println("Triângulo Equilatero:");
        System.out.println("Lado1: " + lados[0]);
        System.out.println("Lado2: " + lados[1]);
        System.out.println("Lado3: " + lados[2]);
        System.out.println("Perimetro: " + calcularPerimetro());
        System.out.println("Area: " + calcularArea());
        System.out.println();
    }
}
