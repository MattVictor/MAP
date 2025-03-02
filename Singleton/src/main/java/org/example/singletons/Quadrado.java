package org.example.singletons;

import java.security.InvalidParameterException;

public class Quadrado implements FiguraMethods {

    private Double lado;

    public Quadrado(Double lado) {
        if (validarLado(lado)) {
            this.lado = lado;
        }
    }

    private boolean validarLado(Double lado) {
        if (lado <= 0) throw new InvalidParameterException("Lado deve ser maior que 0");
        return true;
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    @Override
    public Double calcularArea() {
        return lado * lado;
    }

    @Override
    public Double calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public void printarDados() {
        System.out.println("Quadrado:");
        System.out.println("Lado: " + lado);
        System.out.println("Perimetro: " + calcularPerimetro());
        System.out.println("Area: " + calcularArea());
        System.out.println();
    }
}
