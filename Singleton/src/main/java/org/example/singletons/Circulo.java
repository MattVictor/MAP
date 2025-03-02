package org.example.singletons;

import java.security.InvalidParameterException;

public class Circulo implements FiguraMethods {

    private static Circulo circulo = null;

    private Double raio;

    private Circulo(Double raio) {
        this.raio = raio;
    }

    public static Circulo getInstance(Double raio) {
        if(!validarRaio(raio)){
            throw new InvalidParameterException("Raio deve ser maior que 0");
        }
        if (circulo == null) {
            circulo = new Circulo(raio);
        }
        else {
            throw new InstantiationError("Circulo have already been instantiated");
        }
        return circulo;
    }

    private static boolean validarRaio(Double raio) {
        if (raio <= 0)
            return false;
        return true;
    }

    public static Circulo getInstance() {
        return circulo;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    @Override
    public Double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public Double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public void printarDados() {
        System.out.println("Circulo:");
        System.out.println("Raio: " + raio);
        System.out.println("Perimetro: " + calcularPerimetro());
        System.out.println("Area: " + calcularArea());
        System.out.println();
    }
}
