package FachadasSIG;

import Setores.GestorAlunos;
import Setores.GestorProfessores;

import java.util.ArrayList;

public class FachadaMembros {

    GestorAlunos gestorAlunos;
    GestorProfessores gestorProf;

    public FachadaMembros(){
        this.gestorAlunos = new GestorAlunos();
        this.gestorProf = new GestorProfessores();
    }

    public ArrayList<String> getAlocacaoPorDisciplina() {
        return gestorProf.getAlocacaoPorDisciplina();
    }

    public ArrayList<String> getTempoDeCasa() {
        return gestorProf.getTempoDeCasa();
    }

    public ArrayList<String> getRDM() {
        return gestorAlunos.getRDM();
    }

    public ArrayList<String> getHistorico() {
        return gestorAlunos.getHistorico();
    }
}
