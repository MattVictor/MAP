package org.example.Tests;

import org.example.AlunoDisciplina;
import org.example.Exceptions.ProfessorNotFound;
import org.example.ProfessorDisciplina;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestesProfessor extends TesteSetup {

    @Before
    public void setUp() {
        config();
    }

    @Test
    public void horarioDoProfessor(){
        AlunoDisciplina disc = controleAcademico.getRelacaoAlunoDisciplina().getLast(); // pode dar NotFound

        String[][] horario = disc.getHorario().getMatrizHorario();

        Assert.assertEquals(horario[2][0], "BD");
    }

    @Test (expected = ProfessorNotFound.class)
    public void procurarProfessor() throws ProfessorNotFound {
        controleAcademico.procurarProfessor("Heron");
    }

    @Test
    public void professorJaExiste(){
        Assert.assertEquals(controleAcademico.getProfessores().getLast().getNome(),"Fabio");
    }

    @Test
    public void QuantidadeDeDisciplinasMinistradas(){
        ArrayList<ProfessorDisciplina> profDisc = controleAcademico.getRelacaoProfessorDisciplina();

        int contador = 0;

        for(ProfessorDisciplina prof : profDisc){
            if(prof.getProfessor().getNome().equals("Fabio"))
                contador++;
        }

        Assert.assertEquals(contador, 1);
    }
}
