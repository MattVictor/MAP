import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        SIG sistemaInfoGeral = new SIG();

        ArrayList<Date> reunioes = sistemaInfoGeral.getReunioesAgendadas();
        ArrayList<String> entrevistas = sistemaInfoGeral.getEntrevistas();
        ArrayList<String> balanco = sistemaInfoGeral.getBalancoDeContas();
        ArrayList<String> folhaDePagamento = sistemaInfoGeral.getFolhaDePagamento();


        ArrayList<String> alocacaoProfessor = sistemaInfoGeral.getAlocacaoPorDisciplina();
        ArrayList<String> tempoDeCasaProfessor = sistemaInfoGeral.getTempoDeCasa();
        ArrayList<String> rdmAluno = sistemaInfoGeral.getRDM();
        ArrayList<String> historicoAluno = sistemaInfoGeral.getHistorico();

        ArrayList<String> alocacaoGeral = sistemaInfoGeral.getAlocacaoGeral();
        ArrayList<String> alocacaoSala = sistemaInfoGeral.getAlocacaoSala();
        ArrayList<String> estoque = sistemaInfoGeral.getEstoque();
        ArrayList<String> pedidoDeCompra = sistemaInfoGeral.getPedidoDeCompra();
    }
}
