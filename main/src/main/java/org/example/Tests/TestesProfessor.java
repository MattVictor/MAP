package org.example.Tests;

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
    public void horarioDoProfessor(){}

    @Test
    public void procurarProfessor(){}

    @Test
    public void professorJaExiste(){}

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
