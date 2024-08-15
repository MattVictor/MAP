package org.example.Tests;
import org.example.*;
import org.example.Exceptions.AlunoNotFound;
import org.example.Exceptions.DisciplinaNotFound;
import org.example.Exceptions.ProfessorNotFound;
import org.junit.*;

public class Testes extends TesteSetup {

    @Before
    public void setUp() {
        config();
    }

    @Test
    public void testarHorarioDoAluno() throws AlunoNotFound {

        Aluno aluno = controleAcademico.getAlunos().getFirst();
        Disciplina disciplina = controleAcademico.getDisciplinasDoAluno(aluno.getNome()).getFirst(); // pode dar NotFound

        Horario horarioDaDisc = disciplina.getHorario();
        Horario horarioDoAluno = aluno.getHorario();

        verificarIgualdadeDosHorarios(horarioDoAluno, horarioDaDisc, disciplina.getNome());
    }

    @Test
    public void testarHorarioDosProfessores() throws ProfessorNotFound {

        Professor professor = controleAcademico.getProfessores().getFirst();
        Disciplina disciplina = controleAcademico.getDisciplinasDoProfessor(professor.getNome()).getFirst();

        Horario horarioDaDisc = disciplina.getHorario();
        Horario horarioDoProfessor = professor.getHorario();

        verificarIgualdadeDosHorarios(horarioDoProfessor, horarioDaDisc, disciplina.getNome());
    }

    private void verificarIgualdadeDosHorarios(Horario horarioDoMembro, Horario horarioDaDisciplina, String nomeDaDisciplina) {

        String[][] matrizDoHorarioDaDisc = horarioDaDisciplina.getMatrizHorario();
        String[][] matrizDoHorarioDoMembro = horarioDoMembro.getMatrizHorario();

        for (int i = 0; i < matrizDoHorarioDoMembro.length; i++) {
            for (int j = 0; j < matrizDoHorarioDoMembro[0].length; j++) {
                if (matrizDoHorarioDaDisc[i][j].equals("T")) {
                    Assert.assertEquals(matrizDoHorarioDoMembro[j][i], nomeDaDisciplina);
                }
            }
        }
    }

    @Test
    public void testarQuantidadeDeAlunosDaDisciplina() throws DisciplinaNotFound {

        Disciplina disciplina = controleAcademico.getDisciplinas().getFirst();

        Assert.assertEquals(4, controleAcademico.getAlunosDaDisciplina(disciplina.getNome()).size());
    }
}
