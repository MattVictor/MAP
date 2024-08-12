package org.example.Tests;
import org.example.*;
import org.junit.*;

public class Testes extends TesteSetup {

    @Before
    public void setUp() {
        config();
    }

    @Test
    public void testarHorarioDoAluno() {

        Aluno aluno = controleAcademico.getAlunos().get(0);
        Disciplina disciplina = aluno.getDisciplinas().get(0);

        Horario horarioDaDisc = disciplina.getHorario();
        Horario horarioDoAluno = aluno.getHorario();

        String[][] matrizDoHorarioDaDisc = horarioDaDisc.getMatrizHorario();
        String[][] matrizDoHorarioDoAluno = horarioDoAluno.getMatrizHorario();

        for (int i = 0; i < matrizDoHorarioDoAluno.length; i++) {
            for (int j = 0; j < matrizDoHorarioDoAluno[0].length; j++) {
                if (matrizDoHorarioDaDisc[i][j].equals("T")) {
                    Assert.assertEquals(matrizDoHorarioDoAluno[j][i], disciplina.getNome());
                }
            }
        }
    }

    @Test
    public void testarHorarioDosProfessores() {

        Professor professor = controleAcademico.getProfessores().get(0);
        Disciplina disciplina = professor.getDisciplinas().get(0);

        Horario horarioDaDisc = disciplina.getHorario();
        Horario horarioDoProfessor = professor.getHorario();

        String[][] matrizDoHorarioDaDisc = horarioDaDisc.getMatrizHorario();
        String[][] matrizDoHorarioDoProfessor = horarioDoProfessor.getMatrizHorario();

        for (int i = 0; i < matrizDoHorarioDoProfessor.length; i++) {
            for (int j = 0; j < matrizDoHorarioDoProfessor[0].length; j++) {
                if (matrizDoHorarioDaDisc[i][j].equals("T")) {
                    Assert.assertEquals(matrizDoHorarioDoProfessor[j][i], disciplina.getNome());
                }
            }
        }
    }

    @Test
    public void testarQuantidadeDeAlunos() {

        Disciplina disciplina = controleAcademico.getDisciplinas().get(0);

        Assert.assertEquals(4, disciplina.getAlunos().size());
    }
}
