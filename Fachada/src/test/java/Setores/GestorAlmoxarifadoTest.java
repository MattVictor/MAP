package Setores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorAlmoxarifadoTest {
    static GestorAlmoxarifado gestorTeste;

    @BeforeAll
    public static void setup(){
        gestorTeste = new GestorAlmoxarifado();
    }

    @Test
    public void testarAdicaoEstoque(){
        Assertions.assertEquals(gestorTeste.adicionarAoEstoque("LivroTeste"),"LivroTeste");
    }

    @Test
    public void testarAdicaoPedidoDeCompra(){
        Assertions.assertEquals(gestorTeste.adicionarPedidoDeCompra("PedidoDeLivros"),"PedidoDeLivros");
    }
}