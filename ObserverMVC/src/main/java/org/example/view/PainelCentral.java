package org.example.view;

import org.example.controller.*;
import org.example.model.*;

import java.util.ArrayList;

public class PainelCentral implements AssentoListener {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    private final AssentosController controller;
    private ArrayList<Onibus> onibusExibidos = new ArrayList<>();

    public PainelCentral(AssentosController controller) {
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

    public void exibirAssentos() {

        System.out.println("PAINEL CENTRAL");

        for (Onibus onibus : onibusExibidos) {
            System.out.println(onibus.getNumero());

            int cont = 0;
            for (Assento assento : onibus.getAssentos()) {
                int numero = assento.getNumero();

                String cor = switch (assento.getStatus()) {
                    case "Disponível" -> GREEN;
                    case "Reservado" -> YELLOW;
                    case "Indisponível" -> RED;
                    default -> "RESET";
                };

                System.out.print(cor + (numero<10? "0" : "") + numero + " " + RESET);

                cont++;
                if (cont % 4 == 0 || cont == onibus.getNumAssentos()) {System.out.println();}
            }
            System.out.println();
        }
    }

    public void updateAssentos() {

        onibusExibidos = controller.getOnibus();
    }
}
