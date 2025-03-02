package FachadasSIG;

import Setores.SetorAdministrativo;
import Setores.SetorFinanceiro;

import java.util.ArrayList;
import java.util.Date;

public class FachadaExecutivo {

    SetorAdministrativo setorAdministrativo;
    SetorFinanceiro setorFinanceiro;

    public FachadaExecutivo(){
        this.setorAdministrativo = new SetorAdministrativo();
        this.setorFinanceiro = new SetorFinanceiro();
    }

    public ArrayList<Date> getReunioesAgendadas() {
        return setorAdministrativo.getReunioesAgendadas();
    }

    public ArrayList<String> getEntrevistas() {
        return setorAdministrativo.getEntrevistas();
    }

    public ArrayList<String> getBalancoDeContas() {
        return setorFinanceiro.getBalancoDeContas();
    }

    public ArrayList<String> getFolhaDePagamento() {
        return setorFinanceiro.getFolhaDePagamento();
    }
}
