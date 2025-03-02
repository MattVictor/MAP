package org.example.view;

import org.example.controller.*;
import org.example.model.*;

import java.util.ArrayList;

public class Quiosque implements AssentoListener {

    private final AssentosController controller;
    private ArrayList<Onibus> onibusExibidos = new ArrayList<>();

    public Quiosque(AssentosController controller) {
        this.controller = controller;
    }

    @Override
    public void assentoDisponivel(AssentoEvent e) {
        updateAssentos();
    }

    @Override
    public void assentoReservado(AssentoEvent e) {
        updateAssentos();
    }

    @Override
    public void assentoComprado(AssentoEvent e) {
        updateAssentos();
    }

    public void updateAssentos() {
        onibusExibidos = controller.getOnibus();
    }

    public void exibirAssentos() {

        System.out.println("QUIOSQUE");

        for (Onibus onibus : onibusExibidos) {
            System.out.println(onibus.getNumero());

            for (Assento assento : onibus.getAssentos()) {
                int numero = assento.getNumero();
                System.out.println("Assento " + (numero<10? "0" : "") + numero + " (" + assento.getStatus() + ")");
            }
            System.out.println();
        }
    }
}
