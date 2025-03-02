package org.example.Visitors;

import org.example.Figuras.*;

public class VisitorMax implements VisitaFigura{
    @Override
    public void visitaRetangulo(Retangulo retangulo) {
        System.out.println("Retangulo Maximo:");
        System.out.println("Largura: " + retangulo.getLargura()*2);
        System.out.println("Altura: " + retangulo.getAltura()*2);
    }

    @Override
    public void visitaCirculo(Circulo circulo) {
        System.out.println("Circulo Maximo:");
        System.out.println("Raio: " + circulo.getRaio()*2);
    }

    @Override
    public void visitaTriangulo(Triangulo triangulo) {
        System.out.println("Triangulo Maximo:");
        System.out.println("Lado 1: " + triangulo.getLado1()*2);
        System.out.println("Lado 2: " + triangulo.getLado2()*2);
        System.out.println("Base: " + triangulo.getBase()*2);
        System.out.println("Altura: " + triangulo.getAltura()*2);
    }

    @Override
    public void visitaTrapezio(Trapezio trapezio) {
        System.out.println("Trapezio Maximo:");
        System.out.println("Base Maior: " + trapezio.getBaseMaior()*2);
        System.out.println("Base Menor: " + trapezio.getBaseMenor()*2);
        System.out.println("Lado Oblíquo Esquerdo: " + trapezio.getLadoObliquoE()*2);
        System.out.println("Lado Oblíquo Direito: " + trapezio.getLadoObliquoD()*2);
        System.out.println("Altura: " + trapezio.getAltura()*2);
    }
}
