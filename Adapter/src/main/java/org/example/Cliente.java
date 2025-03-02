package org.example;

import org.example.Adapters.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Cliente {

    static MapToList lista;
    static ListToMap map;
    static ConsolePrinter printer;

    public static void main(String[] args) {

        lista = new MapToList(new HashMap<Integer, String>());
        map = new ListToMap(new ArrayList<>());
        printer = new ConsolePrinter();

        introduzirElementosList("Matheus", "Vinicius", "Sabrina");  // lista.add()
        introdizurElementosMap("Victor", "John", "Luiz");  // map.put()

        // MANIPULANDO A MAPTOLIST
        System.out.println("LIST");

        printer.iterarLista(lista);                              // lista.iterator()
        printer.pegarElementoLista(lista,0);               // lista.get()
        printer.tamanhoLista(lista);                             // lista.size()
        printer.contemElementoLista(lista,"Sabrina");   // lista.contains()

        System.out.println("Removendo elementos: Matheus");
        removerElementosPorIndex(0);                             // lista.remove()

        printer.tamanhoLista(lista);
        printer.iterarLista(lista);

        printer.isEmptyList(lista);                              // lista.isEmpty()
        printer.emptyList(lista);                                // lista.clear()


        // MANIPULANDO LISTTOMAP
        System.out.println("MAP");

        printer.mapValues(map);                                  // map.values()
        printer.pegarElementoMap(map,1);                   // map.get()
        printer.tamanhoMap(map);                                 // map.size()

        printer.contemChaveMap(map,3);                     // map.containsKey()
        printer.contemValorMap(map,"Luiz");                 // map.containsValue()

        System.out.println("Removendo elementos: Victor, John");
        removerElementosMap(1,0);                        // map.remove()

        printer.tamanhoMap(map);
        printer.mapValues(map);

        printer.isEmptyMap(map);                                 // map.isEmpty()
        printer.emptyMap(map);                                   // map.clear()
    }

    public static void introduzirElementosList(String... elementos){
        for(String e : elementos){
            lista.add(e);
        }
    }

    public static void removerElementosPorIndex(int... index){
        for(int i : index){
            lista.remove(i);
        }
    }

    public static void introdizurElementosMap(String... valores){
        for(int i = 0; i < valores.length; i++){
            map.put(i,valores[i]);
        }
    }

    public static void removerElementosMap(Integer... chaves){
        for(Integer chave : chaves)
            map.remove(chave);
    }
}