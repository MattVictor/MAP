package org.example.main;

import org.example.controller.*;
import org.example.model.*;
import org.example.view.*;
import org.example.exceptions.AssentoIndisponivel;
import org.example.exceptions.AssentoInvalido;
import org.example.exceptions.OnibusInvalido;

import java.util.Date;

public class Main {

    private static Rodoviaria rodoviaria;
    private static AssentosController statusController;
    private static PainelCentral painelCentral;
    private static Quiosque quiosque;

    public static void main(String[] args) {

        try {
            rodoviaria = new Rodoviaria();
            statusController = new AssentosController(rodoviaria);
            painelCentral = new PainelCentral(statusController);
            quiosque = new Quiosque(statusController);

            criarFrota();
            statusController.addInterfaces(painelCentral);
            statusController.addInterfaces(quiosque);

            exemploReservasECompras(); // algumas reservas e compras feitas no onibus 100

            painelCentral.exibirAssentos();
            quiosque.exibirAssentos();
        }
        catch (OnibusInvalido | AssentoInvalido | AssentoIndisponivel e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exemploReservasECompras() throws OnibusInvalido, AssentoInvalido, AssentoIndisponivel {
        statusController.reservarAssento(100,3,"Vinicius");
        statusController.reservarAssento(100,6,"Vinicius");
        statusController.reservarAssento(100,11,"Vinicius");
        statusController.reservarAssento(100,17,"Vinicius");

        statusController.comprarAssento(100,4,"Matheus");
        statusController.comprarAssento(100,13,"Matheus");
        statusController.comprarAssento(100,19,"Matheus");
        statusController.comprarAssento(100,20,"Matheus");
    }

    private static void criarFrota() {

        Date[] horariosChegada = definirHorariosChegada();
        Date[] horariosSaida = definirHorariosSaida();

        rodoviaria.adicionarOnibus(100,"Itabaiana", horariosChegada[0], horariosSaida[0], 20);
        rodoviaria.adicionarOnibus(200,"João Pessoa", horariosChegada[1], horariosSaida[1], 26);
        rodoviaria.adicionarOnibus(300,"Montadas",horariosChegada[2], horariosSaida[2], 24);
    }

    private static Date[] definirHorariosChegada() {
        Date horario1 = new Date(2024,11,9,6,30);
        Date horario2 = new Date(2024,11,9,7,30);
        Date horario3 = new Date(2024,11,9,8,00);

        return new Date[]{horario1, horario2, horario3};
    }

    private static Date[] definirHorariosSaida() {
        Date horario1 = new Date(2024,11,9,7,30);
        Date horario2 = new Date(2024,11,9,8,30);
        Date horario3 = new Date(2024,11,9,9,00);

        return new Date[]{horario1, horario2, horario3};
    }
}