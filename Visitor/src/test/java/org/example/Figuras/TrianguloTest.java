package org.example.Figuras;

import org.example.Visitors.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrianguloTest {
    Triangulo trianguloTeste;

    @Before
    public void setup() throws Exception {
        trianguloTeste = new Triangulo(12,12,12);
    }

    @Test
    public void criarTrianguloEquilatero() throws Exception {
        Triangulo trianguloEquilatero = new Triangulo(8,8,8);
        assertEquals(trianguloEquilatero.getTipo(), "Equilatero");
    }

    @Test
    public void criarTrianguloIsoceles() throws Exception {
        Triangulo trianguloEquilatero = new Triangulo(8,5,8);
        assertEquals(trianguloEquilatero.getTipo(), "Isoceles");
    }

    @Test
    public void criarTrianguloEscaleno() throws Exception {
        Triangulo trianguloEquilatero = new Triangulo(8,9,10);
        assertEquals(trianguloEquilatero.getTipo(), "Escaleno");
    }

    @Test (expected = Exception.class)
    public void criarTrianguloNegativo() throws Exception {
        Triangulo trianguloEquilatero = new Triangulo(8,8,-1);
    }

    @Test (expected = Exception.class)
    public void criarTrianguloLadoIgualAZero() throws Exception {
        Triangulo trianguloEquilatero = new Triangulo(8,0,8);
    }

    @Test (expected = Exception.class)
    public void criarNaoTriangulo() throws Exception {
        Triangulo trianguloEquilatero = new Triangulo(2,2,5);
    }

    @Test
    public void baseTrianguloEquilatero() throws Exception {
        Triangulo trianguloEquilatero = new Triangulo(8,8,8);
        assertEquals(trianguloEquilatero.getBase(), 8,0);
    }

    @Test
    public void baseTrianguloIsoceles() throws Exception {
        Triangulo trianguloEquilatero = new Triangulo(8,5,8);
        assertEquals(trianguloEquilatero.getBase(), 5,0);
    }

    @Test
    public void baseTrianguloEscaleno() throws Exception {
        Triangulo trianguloEquilatero = new Triangulo(8,9,10);
        assertEquals(trianguloEquilatero.getBase(), 10,0);
    }

    @Test
    public void testeAltura(){
        assertEquals(trianguloTeste.getAltura(), 10.39,0.1);
    }

    @Test
    public void aceitaVisitaArea(){
        VisitorArea visitorTeste = new VisitorArea();

        trianguloTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaPerimetro(){
        VisitorPerimetro visitorTeste = new VisitorPerimetro();

        trianguloTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaMaximo(){
        VisitorMax visitorTeste = new VisitorMax();

        trianguloTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaDesenho(){
        VisitorDesenhar visitorTeste = new VisitorDesenhar();

        trianguloTeste.aceitaVisita(visitorTeste);
    }
}