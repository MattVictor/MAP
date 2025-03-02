package org.example.main;

import org.example.singletons.Circulo;
import org.example.singletons.Quadrado;
import org.example.singletons.Triangulo;

public class Main {
    public static void main(String[] args) {
        try {
            FabricaDeFormas fabrica = new FabricaDeFormas();

            Circulo circulo = fabrica.criarCirculo(10.0);
            //Circulo circulo2 = fabrica.criarCirculo(20.0);

            Quadrado quadrado = fabrica.criarQuadrado(10.0);
            Quadrado quadrado2 = fabrica.criarQuadrado(20.0);

            Triangulo trianguloEquilatero = fabrica.criarTrianguloEquilatero(2.0, 2.0, 2.0);
            Triangulo trianguloIsosceles = fabrica.criarTrianguloIsosceles(2.0, 3.0, 2.0);
            Triangulo trianguloRetangulo = fabrica.criarTrianguloRetangulo(3.0, 4.0, 5.0);

            circulo.printarDados();
            quadrado.printarDados();
            quadrado2.printarDados();
            trianguloEquilatero.printarDados();
            trianguloIsosceles.printarDados();
            trianguloRetangulo.printarDados();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}