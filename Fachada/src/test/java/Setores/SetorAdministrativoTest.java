package Setores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SetorAdministrativoTest {

    static SetorAdministrativo setorTeste;
    private static String entrevista = "Entrevista 008";
    private static Date data = new Date(100);

    @BeforeAll
    public static void setup(){
        setorTeste = new SetorAdministrativo();
        setorTeste.registrarNovaEntrevista(entrevista);
        setorTeste.agendarNovaReuniao(data);
    }

    @Test
    public void adicionarReuniao(){
        Assertions.assertEquals(setorTeste.agendarNovaReuniao(data),"Reunião agendada com Sucesso!");
    }

    @Test
    public void adicionarEntrevista(){
        Assertions.assertEquals(setorTeste.registrarNovaEntrevista("Entrevista 005"), "Entrevista Registrada");
    }

    @Test
    public void verificarEntrevista(){
        Assertions.assertEquals(setorTeste.getEntrevistas().getFirst(), entrevista);
    }

    @Test
    public void verificarHorarioReuniao(){
        Assertions.assertEquals(setorTeste.getReunioesAgendadas().getLast(), data);
    }
}