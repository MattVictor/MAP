package org.example.Tests;

import org.example.Aluno;
import org.example.AlunoDisciplina;
import org.example.Disciplina;
import org.example.Exceptions.AlunoNotFound;
import org.example.Horario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestesAluno extends TesteSetup {

    @Before
    public void setUp(){
        config();
    }

    @Test
    public void horarioDoAluno(){
        AlunoDisciplina disc = controleAcademico.getRelacaoAlunoDisciplina().getFirst(); // pode dar NotFound

        String[][] horario = disc.getHorario().getMatrizHorario();

        Assert.assertEquals(horario[0][0], "MAP");
    }

    @Test (expected = AlunoNotFound.class)
    public void alunoNaoExiste() throws AlunoNotFound {
        String nomeAluno = "Vinicius";
        controleAcademico.procurarAluno(nomeAluno);
    }

    @Test
    public void procurarAluno() throws AlunoNotFound {
        Aluno alunoTeste = controleAcademico.procurarAluno("Matheus");

        Assert.assertEquals(alunoTeste,controleAcademico.getAlunos().getFirst());
    }

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
