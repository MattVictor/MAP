package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RodoviariaTest {
    Rodoviaria rodTeste;

    @BeforeEach
    public void setup(){
        rodTeste = new Rodoviaria();

        rodTeste.adicionarOnibus(5,"Areia",new Date(15), new Date(10),15);
        rodTeste.adicionarOnibus(15,"Bananeiras",new Date(15), new Date(10),25);
        rodTeste.adicionarOnibus(25,"Juarez Távora",new Date(15), new Date(10),35);
    }

    @Test
    public void adicionarNovoOnibus(){
        rodTeste.adicionarOnibus(new Onibus(55,"Camutanga",new Date(20),new Date(30), 50));

        assertEquals(55,rodTeste.getFrota().getLast().getNumero());
    }

    @Test
    public void removerOnibus(){
        rodTeste.removerOnibus(rodTeste.getFrota().getFirst());

        assertEquals(15,rodTeste.getFrota().getFirst().getNumero());
    }
}