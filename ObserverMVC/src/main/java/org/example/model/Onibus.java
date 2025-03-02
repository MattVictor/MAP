package org.example.model;

import java.util.ArrayList;
import java.util.Date;

public class Onibus {

    private final int numero;
    private String destino;
    private Date chegada;
    private Date saida;
    private final int numAssentos;

    private ArrayList<Assento> assentos = new ArrayList<>();

    public Onibus(int numero, String destino, Date chegada, Date saida, int numAssentos) {
        this.numero = numero;
        this.destino = destino;
        this.chegada = chegada;
        this.saida = saida;
        this.numAssentos = numAssentos;

        for (int i = 0; i < numAssentos; i++) {
            Assento novoAssento = new Assento(i+1);
            novoAssento.disponibilizarAssento();
            assentos.add(novoAssento);
        }
    }

    // GETTERS E SETTERS

    public int getNumero() {
        return numero;
    }

    public String getDestino() {
        return destino;
    }

    public Date getChegada() {
        return chegada;
    }

    public Date getSaida() {
        return saida;
    }

    public ArrayList<Assento> getAssentos() {
        return assentos;
    }

    public int getNumAssentos() {
        return numAssentos;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setChegada(Date chegada) {
        this.chegada = chegada;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }
}
