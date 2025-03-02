package Setores;

import java.util.ArrayList;

public class GestorAlmoxarifado {

    ArrayList<String> estoque;
    ArrayList<String> pedidoDeCompra;

    public GestorAlmoxarifado(){
        this.estoque = new ArrayList<>();
        this.pedidoDeCompra = new ArrayList<>();
    }

    public String adicionarAoEstoque(String novoItem){
        this.estoque.add(novoItem);

        return this.estoque.getLast();
    }

    public String adicionarPedidoDeCompra(String pedido){
        this.pedidoDeCompra.add(pedido);

        return this.pedidoDeCompra.getLast();
    }

    public ArrayList<String> getEstoque() {
        return estoque;
    }

    public ArrayList<String> getPedidoDeCompra() {
        return pedidoDeCompra;
    }
}
