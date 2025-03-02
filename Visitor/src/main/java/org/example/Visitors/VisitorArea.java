package org.example.Visitors;

import org.example.Figuras.*;
public class VisitorArea implements VisitaFigura{
    @Override
    public void visitaRetangulo(Retangulo retangulo) {
        double area = retangulo.getAltura() * retangulo.getLargura();
        System.out.println("Área do Retangulo: " + area);
    }

    @Override
    public void visitaCirculo(Circulo circulo) {
        double area = 3.14*(circulo.getRaio()*circulo.getRaio());
        System.out.println("Área do Circulo: " + area);
    }

    @Override
    public void visitaTriangulo(Triangulo triangulo) {
        double area = (triangulo.getBase()*triangulo.getAltura())/2;
        System.out.println("Área do Triangulo: " + area);
    }

    @Override
    public void visitaTrapezio(Trapezio trapezio) {
        double area = ((trapezio.getBaseMaior()+ trapezio.getBaseMenor())* trapezio.getAltura())/2;
        System.out.println("Área do Trapezio: " + area);
    }
}
