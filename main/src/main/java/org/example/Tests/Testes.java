package org.example.Tests;
import org.example.*;
import org.example.Exceptions.AlunoNotFound;
import org.example.Exceptions.DisciplinaNotFound;
import org.example.Exceptions.ProfessorNotFound;
import org.junit.*;

import java.util.ArrayList;

public class Testes extends TesteSetup {

    @Before
    public void setUp() {
        config();
    }

    @Test
    public void testarHorarioDoAluno() throws AlunoNotFound {

        Aluno aluno = controleAcademico.getAlunos().getFirst();
        Disciplina disciplina = controleAcademico.getDisciplinasDoAluno(aluno.getNome()).getLast(); // pode dar NotFound

        System.out.println(disciplina.getNome());
        Horario horarioDaDisc = disciplina.getHorario();
        Horario horarioDoAluno = aluno.getHorario();

        verificarIgualdadeDosHorarios(horarioDoAluno, 6, 2, disciplina.getNome());
    }

    @Test
    public void testarHorarioDosProfessores() throws ProfessorNotFound {

        Professor professor = controleAcademico.getProfessores().getFirst();
        Disciplina disciplina = controleAcademico.getDisciplinasDoProfessor(professor.getNome()).getFirst();

        Horario horarioDaDisc = disciplina.getHorario();
        Horario horarioDoProfessor = professor.getHorario();

        verificarIgualdadeDosHorarios(horarioDoProfessor, 0, 0, disciplina.getNome());
    }

    private void verificarIgualdadeDosHorarios(Horario horarioDoMembro, int i, int j, String nomeDaDisciplina) {
        String[][] matrizDoHorarioDoMembro = horarioDoMembro.getMatrizHorario();

        Assert.assertEquals(matrizDoHorarioDoMembro[i][j], nomeDaDisciplina);
    }

    @Test
    public void testarQuantidadeDeAlunosDaDisciplina() throws DisciplinaNotFound {

        Disciplina disciplina = controleAcademico.getDisciplinas().getFirst();

        Assert.assertEquals(4, controleAcademico.getAlunosDaDisciplina(disciplina.getNome()).size());
    }

    @Test (expected = AlunoNotFound.class)
    public void testarThrowAluno() throws AlunoNotFound {
        String nomeAluno = "Vinicius";
        controleAcademico.procurarAluno(nomeAluno);

    }

    @Test
    public void ProfessorAlocado(){
        ProfessorDisciplina profDisc = controleAcademico.getRelacaoProfessorDisciplina().getFirst();

        Assert.assertEquals(profDisc.getProfessor().getNome(),"Sabrina");
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
