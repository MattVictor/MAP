package Setores;

import java.util.ArrayList;

public class GestorAlunos {

    ArrayList<String> rdms;
    ArrayList<String> historicos;

    public GestorAlunos(){
        rdms = new ArrayList<>();
        historicos = new ArrayList<>();
    }

    public String adicionarRdm(String novoRdm){
        if(this.rdms.contains(novoRdm))
            return "Este RDM já está registrado";

        this.rdms.add(novoRdm);

        return rdms.getLast();
    }

    public String adicionarHistorico(String novoHistorico){
        this.historicos.add(novoHistorico);

        return this.historicos.getLast();
    }

    public ArrayList<String> getRDM() {
        return rdms;
    }

    public ArrayList<String> getHistorico() {
        return historicos;
    }


}
