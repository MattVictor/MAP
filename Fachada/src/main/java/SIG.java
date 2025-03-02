import FachadasSIG.FachadaExecutivo;
import FachadasSIG.FachadaLogistico;
import FachadasSIG.FachadaMembros;

import java.util.ArrayList;
import java.util.Date;

public class SIG {
    private FachadaExecutivo fachadaExecutivo;
    private FachadaLogistico fachadaLogistico;
    private FachadaMembros fachadaMembros;

    public SIG(){
        this.fachadaExecutivo = new FachadaExecutivo();
        this.fachadaLogistico = new FachadaLogistico();
        this.fachadaMembros = new FachadaMembros();
    }

    public ArrayList<Date> getReunioesAgendadas() {
        return fachadaExecutivo.getReunioesAgendadas();
    }

    public ArrayList<String> getEntrevistas() {
        return fachadaExecutivo.getEntrevistas();
    }

    public ArrayList<String> getBalancoDeContas() {
        return fachadaExecutivo.getBalancoDeContas();
    }

    public ArrayList<String> getFolhaDePagamento() {
        return fachadaExecutivo.getFolhaDePagamento();
    }

    public ArrayList<String> getAlocacaoPorDisciplina() {
        return fachadaMembros.getAlocacaoPorDisciplina();
    }

    public ArrayList<String> getTempoDeCasa() {
        return fachadaMembros.getTempoDeCasa();
    }

    public ArrayList<String> getRDM() {
        return fachadaMembros.getRDM();
    }

    public ArrayList<String> getHistorico() {
        return fachadaMembros.getHistorico();
    }

    public ArrayList<String> getAlocacaoGeral() {
        return fachadaLogistico.getAlocacaoGeral();
    }

    public ArrayList<String> getAlocacaoSala() {
        return fachadaLogistico.getAlocacaoSala();
    }

    public ArrayList<String> getEstoque() {
        return fachadaLogistico.getEstoque();
    }

    public ArrayList<String> getPedidoDeCompra() {
        return fachadaLogistico.getPedidoDeCompra();
    }
}
