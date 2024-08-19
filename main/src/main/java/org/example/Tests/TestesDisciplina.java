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
    public void horarioDaDisciplina(){}

    @Test
    public void ProfessorDaDisciplina(){}

    @Test
    public void testarQuantidadeDeAlunosDaDisciplina() throws DisciplinaNotFound {

        Disciplina disciplina = controleAcademico.getDisciplinas().getFirst();

        Assert.assertEquals(4, controleAcademico.getAlunosDaDisciplina(disciplina.getNome()).size());
    }
}
