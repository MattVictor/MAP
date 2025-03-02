package org.example.Tests;

import org.example.Disciplina;
import org.example.Exceptions.DisciplinaNotFound;
import org.example.ProfessorDisciplina;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestesDisciplina extends TesteSetup {

    @Before
    public void setUp() {
        config();
    }

    @Test
    public void horarioDaDisciplina(){
        String[][] horario = controleAcademico.getRelacaoProfessorDisciplina().get(1).getHorario().getMatrizHorario();

        Assert.assertEquals(horario[6][2],"ATAL");
    }

    @Test
    public void ProfessorDaDisciplina(){
        ProfessorDisciplina profDisc = controleAcademico.getRelacaoProfessorDisciplina().getFirst();

        Assert.assertEquals(profDisc.getProfessor().getNome(),"Sabrina");
    }

    @Test
    public void testarQuantidadeDeAlunosDaDisciplina() throws DisciplinaNotFound {

        Disciplina disciplina = controleAcademico.getDisciplinas().getFirst();

        Assert.assertEquals(4, controleAcademico.getAlunosDaDisciplina(disciplina.getNome()).size());
    }
}
