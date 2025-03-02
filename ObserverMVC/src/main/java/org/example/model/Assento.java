package org.example.model;

import org.example.controller.AssentoEvent;
import org.example.controller.AssentoListener;
import java.util.ArrayList;

public class Assento {

    private int numero;
    private String status;
    private String ocupante;
    private final ArrayList<AssentoListener> listeners = new ArrayList<>();

    public Assento(int numero) {
        this.numero = numero;
        this.ocupante = "nenhum";
    }

    public void comprarAssento(String comprador) {
        status = "Indisponível";
        ocupante = comprador;
        disparaAssentoComprado();
    }

    public void reservarAssento(String reservador) {
        status = "Reservado";
        ocupante = reservador;
        disparaAssentoReservado();
    }

    public void disponibilizarAssento() {
        status = "Disponível";
        ocupante = "nenhum";
        disparaAssentoDisponivel();
    }

    public void addAssentoListener(AssentoListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void removeAssentoListener(AssentoListener listener) {
        listeners.remove(listener);
    }

    private void disparaAssentoComprado() {

        for (AssentoListener listener : listeners) {
            AssentoEvent eventoComprado = new AssentoEvent(this);
            listener.assentoComprado(eventoComprado);
        }
    }

    private void disparaAssentoReservado() {

        for (AssentoListener listener : listeners) {
            AssentoEvent eventoReservado = new AssentoEvent(this);
            listener.assentoReservado(eventoReservado);
        }
    }

    private void disparaAssentoDisponivel() {

        for (AssentoListener listener : listeners) {
            AssentoEvent eventoDisponivel = new AssentoEvent(this);
            listener.assentoDisponivel(eventoDisponivel);
        }
    }


    // GETTERS E SETTERS

    public int getNumero() {
        return numero;
    }

    public String getStatus() {
        return status;
    }

    public String getOcupante() {
        return ocupante;
    }
}
