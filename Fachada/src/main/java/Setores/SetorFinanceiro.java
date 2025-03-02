package Setores;

import java.util.ArrayList;

public class SetorFinanceiro {

    ArrayList<String> balancoDeContas;
    ArrayList<String> folhaDePagamento;

    public SetorFinanceiro(){
        this.balancoDeContas = new ArrayList<>();
        this.folhaDePagamento = new ArrayList<>();
    }

    public String adicionarNovoBalanco(String novoBalanco){
        this.balancoDeContas.add(novoBalanco);

        return this.balancoDeContas.getLast();
    }

    public String adicionarNovaFolha(String novaFolhaDePag){
        this.folhaDePagamento.add(novaFolhaDePag);

        return this.folhaDePagamento.getLast();
    }

    public ArrayList<String> getBalancoDeContas() {
        return balancoDeContas;
    }

    public ArrayList<String> getFolhaDePagamento() {
        return folhaDePagamento;
    }
}
