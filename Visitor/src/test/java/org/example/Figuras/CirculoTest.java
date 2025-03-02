package org.example.Figuras;

import org.example.Visitors.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CirculoTest {
    private Circulo circuloTeste;

    @Before
    public void setup(){
        try {
            circuloTeste = new Circulo(5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void criarNovoCirculo() throws Exception {
        Circulo novoCirculo = new Circulo(10);
    }

    @Test (expected = Exception.class)
    public void circuloComRaioNegativo() throws Exception {
        Circulo circuloNegativo = new Circulo(-12);
    }

    @Test (expected = Exception.class)
    public void circuloComRaioZero() throws Exception {
        Circulo circuloDeRaioZero = new Circulo(0);
    }

    @Test
    public void testarRaio(){
        assertEquals(circuloTeste.getRaio(), 5, 0);
    }

    @Test
    public void aceitaVisitaArea(){
        VisitorArea visitorTeste = new VisitorArea();

        circuloTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaPerimetro(){
        VisitorPerimetro visitorTeste = new VisitorPerimetro();

        circuloTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaMaximo(){
        VisitorMax visitorTeste = new VisitorMax();

        circuloTeste.aceitaVisita(visitorTeste);
    }

    @Test
    public void aceitaVisitaDesenho(){
        VisitorDesenhar visitorTeste = new VisitorDesenhar();

        circuloTeste.aceitaVisita(visitorTeste);
    }
}