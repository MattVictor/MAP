package Setores;

import java.util.ArrayList;

public class SetorInfraestrutura {

    ArrayList<String> alocacaoGeral;
    ArrayList<String> alocacaoSala;

    public SetorInfraestrutura(){
        this.alocacaoGeral = new ArrayList<>();
        this.alocacaoSala = new ArrayList<>();
    }

    public String alocarNovaSala(String salaAlocada){
        this.alocacaoSala.add(salaAlocada);

        return this.alocacaoSala.getLast();
    }

    public boolean salaEstaAlocada(String sala){
        if(this.alocacaoSala.contains(sala))
            return true;
        else
            return false;
    }

    public ArrayList<String> getAlocacaoGeral() {
        return alocacaoGeral;
    }

    public ArrayList<String> getAlocacaoSala() {
        return alocacaoSala;
    }
}
