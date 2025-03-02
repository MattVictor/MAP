package org.example.Figuras;

import org.example.Visitors.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrapezioTest {
    Trapezio trapezioTeste;

    @Before
    public void setup() throws Exception {
        trapezioTeste = new Trapezio(30,10,8);
    }

    @Test
    public void criarNovoTrapezio() throws Exception {
        Trapezio novoTrapezio = new Trapezio(14,25,11);
    }

    @Test (expected = Exception.class)
    public void criarTrapezioBaseNegativa() throws Exception {
        Trapezio trapezioNegativo = new Trapezio(-10,20,9);
    }

    @Test (expected = Exception.class)
    public void criarTrapezioAlturaZero() throws Exception {
        Trapezio trapezioRebaixado = new Trapezio(20,30,0);
    }

    @Test (expected = Exception.class)
    public void criarQuadrado() throws Exception {
        Trapezio quadrado = new Trapezio(10,10,10);
    }

    @Test
    public void ladoOblíquoDireito(){
        assertEquals(trapezioTeste.getLadoObliquoD(), 10,0);
    }

    @Test
    public void ladoOblíquoEsquerdo(){
        assertEquals(trapezioTeste.getLadoObliquoE(), 10, 0);
    }

    @Test
    public void aceitaVisitaArea(){
        VisitorArea visitorTeste = new VisitorArea();

        trapezioTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaPerimetro(){
        VisitorPerimetro visitorTeste = new VisitorPerimetro();

        trapezioTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaMaximo(){
        VisitorMax visitorTeste = new VisitorMax();

        trapezioTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaDesenho(){
        VisitorDesenhar visitorTeste = new VisitorDesenhar();

        trapezioTeste.aceitaVisita(visitorTeste);
    }
}