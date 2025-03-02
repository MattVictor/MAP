package Setores;

import java.util.ArrayList;

public class GestorProfessores {

    ArrayList<String> alocacaoPorDisciplina;
    ArrayList<String> temposDeCasa;

    public GestorProfessores(){
        this.alocacaoPorDisciplina = new ArrayList<>();
        this.temposDeCasa = new ArrayList<>();
    }

    public String alocarNovaDisciplina(String novaDisciplina){
        this.alocacaoPorDisciplina.add(novaDisciplina);

        return this.alocacaoPorDisciplina.getLast();
    }

    public String adicionarTempoDeCasa(String novoTempoDeCasa){
        this.temposDeCasa.add(novoTempoDeCasa);

        return this.temposDeCasa.getLast();
    }

    public ArrayList<String> getAlocacaoPorDisciplina() {
        return alocacaoPorDisciplina;
    }

    public ArrayList<String> getTempoDeCasa() {
        return temposDeCasa;
    }
}
