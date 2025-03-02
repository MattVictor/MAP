package org.example.Visitors;

import org.example.Figuras.*;

public class VisitorPerimetro implements VisitaFigura{
    @Override
    public void visitaRetangulo(Retangulo retangulo) {
        double perimetro = retangulo.getAltura()*2 + retangulo.getLargura()*2;
        System.out.println("Perimetro do Retangulo: " + perimetro);
    }

    @Override
    public void visitaCirculo(Circulo circulo) {
        double perimetro = 2*3.14*circulo.getRaio();
        System.out.println("Perimetro do Circulo: " + perimetro);
    }

    @Override
    public void visitaTriangulo(Triangulo triangulo) {
        double perimetro = triangulo.getLado1()+ triangulo.getLado2()+ triangulo.getBase();
        System.out.println("Perimetro do Triangulo: " + perimetro);
    }

    @Override
    public void visitaTrapezio(Trapezio trapezio) {
        double perimetro = trapezio.getBaseMaior()+trapezio.getBaseMenor()+ trapezio.getLadoObliquoE()+trapezio.getLadoObliquoE();
        System.out.println("Perimetro do Trapezio: " + perimetro);
    }
}
