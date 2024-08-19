package org.example.Tests;

import org.example.AlunoDisciplina;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestesAluno extends TesteSetup {

    @Before
    public void setUp() {
        config();
    }

    @Test
    public void horarioDoAluno(){
    }

    @Test
    public void procurarAluno(){}

    @Test
    public void alunoJaExiste(){}

    @Test
    public void QuantiadadeDeDisciplinasMatriculadas(){
        ArrayList<AlunoDisciplina> alnDic = controleAcademico.getRelacaoAlunoDisciplina();

        int contador = 0;

        for(AlunoDisciplina aln : alnDic){
            if(aln.getAluno().getNome().equals("Matheus"))
                contador++;
        }

        Assert.assertEquals(contador, 2);
    }
}
