package Setores;

import java.util.ArrayList;
import java.util.Date;

public class SetorAdministrativo {

    ArrayList<Date> reunioesAgendadas;
    ArrayList<String> entrevistas;

    public SetorAdministrativo(){
        this.reunioesAgendadas = new ArrayList<>();
        this.entrevistas = new ArrayList<>();
    }

    public String agendarNovaReuniao(Date horarioDaNovaReuniao){
        this.reunioesAgendadas.add(horarioDaNovaReuniao);

        return "Reunião agendada com Sucesso!";
    }

    public String registrarNovaEntrevista(String novaEntrevista){
        this.entrevistas.add(novaEntrevista);

        return "Entrevista Registrada";
    }

    public ArrayList<Date> getReunioesAgendadas() {
        return reunioesAgendadas;
    }

    public ArrayList<String> getEntrevistas() {
        return entrevistas;
    }
}
