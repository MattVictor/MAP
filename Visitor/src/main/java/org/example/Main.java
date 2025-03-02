package org.example;

import org.example.Visitors.*;
import org.example.Figuras.*;

public class Main {
    private static Retangulo retangulo;
    private static Circulo circulo;
    private static Triangulo triangulo;
    private static Trapezio trapezio;

    public static void main(String[] args) {
        try {
            retangulo = new Retangulo(20,10);
            circulo = new Circulo(5);
            triangulo = new Triangulo(9,4,9);
            trapezio = new Trapezio(50,30,8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        getTodosOsDados();

//        areaTodasAsFiguras();
//        perimetroTodasAsFiguras();
//        maximoTodasAsFiguras();
//        desenhoTodasAsFiguras();
    }

    public static void getDado(ElementoConcreto elem, VisitaFigura visitor){
        elem.aceitaVisita(visitor);
    }

    public static void getTodosOsDados(){
        ElementoConcreto[] figuras = {retangulo,circulo,triangulo,trapezio};
        VisitaFigura[] visitors = {new VisitorArea(), new VisitorPerimetro(), new VisitorDesenhar(), new VisitorMax()};

        for(ElementoConcreto figura : figuras){
            for(VisitaFigura visitor : visitors){
                getDado(figura,visitor);
                System.out.println();
            }
        }
    }

    public static void areaTodasAsFiguras(){
        VisitorArea vArea = new VisitorArea();

        retangulo.aceitaVisita(vArea);
        circulo.aceitaVisita(vArea);
        triangulo.aceitaVisita(vArea);
        trapezio.aceitaVisita(vArea);

        System.out.println();
    }

    public static void perimetroTodasAsFiguras(){
        VisitorPerimetro vPerimetro = new VisitorPerimetro();

        retangulo.aceitaVisita(vPerimetro);
        circulo.aceitaVisita(vPerimetro);
        triangulo.aceitaVisita(vPerimetro);
        trapezio.aceitaVisita(vPerimetro);

        System.out.println();
    }

    public static void maximoTodasAsFiguras(){
        VisitorMax vMax = new VisitorMax();

        retangulo.aceitaVisita(vMax);
        circulo.aceitaVisita(vMax);
        triangulo.aceitaVisita(vMax);
        trapezio.aceitaVisita(vMax);

        System.out.println();
    }

    public static void desenhoTodasAsFiguras(){
        VisitorDesenhar vDraw = new VisitorDesenhar();

        retangulo.aceitaVisita(vDraw);
        System.out.println();
        circulo.aceitaVisita(vDraw);
        System.out.println();
        triangulo.aceitaVisita(vDraw);
        System.out.println();
        trapezio.aceitaVisita(vDraw);

        System.out.println();
    }
}