package FachadasSIG;

import Setores.GestorAlmoxarifado;
import Setores.SetorInfraestrutura;

import java.util.ArrayList;

public class FachadaLogistico {

    SetorInfraestrutura setorInfraestrutura;
    GestorAlmoxarifado gestorAlmoxarifado;

    public FachadaLogistico(){
        this.setorInfraestrutura = new SetorInfraestrutura();
        this.gestorAlmoxarifado = new GestorAlmoxarifado();
    }

    public ArrayList<String> getAlocacaoGeral() {
        return setorInfraestrutura.getAlocacaoGeral();
    }

    public ArrayList<String> getAlocacaoSala() {
        return setorInfraestrutura.getAlocacaoSala();
    }

    public ArrayList<String> getEstoque() {
        return gestorAlmoxarifado.getEstoque();
    }

    public ArrayList<String> getPedidoDeCompra() {
        return gestorAlmoxarifado.getPedidoDeCompra();
    }
}
