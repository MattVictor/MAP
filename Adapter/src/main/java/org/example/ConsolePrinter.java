package org.example;

import org.example.Adapters.ListToMap;
import org.example.Adapters.MapToList;

import java.util.Iterator;

public class ConsolePrinter {

    public void iterarLista(MapToList lista){

        System.out.println("Elementos da Lista: ");

        Iterator it = lista.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();
    }

    public void pegarElementoLista(MapToList lista,int index){
        System.out.println("O elemento "+lista.get(index)+" foi retornado da lista");
    }

    public void tamanhoLista(MapToList lista){
        System.out.println("tamanho da lista: "+lista.size()+"\n");
    }

    public void contemElementoLista(MapToList lista,String elemento){
        if(lista.contains(elemento))
            System.out.println("A lista contém o elemento: "+ elemento);
        else
            System.out.println("A lista não contém o elemento");
    }

    public void isEmptyList(MapToList lista) {
        if (lista.isEmpty()) System.out.println("A lista está vazia.");
        else System.out.println("A lista não está vazia.");
    }

    public void emptyList(MapToList lista){
        lista.clear();
        System.out.println("A lista está vazia\n");
    }

    public void pegarElementoMap(ListToMap map, int index){
        System.out.println("O elemento "+map.get(index)+" foi retornado do Map");
    }

    public void tamanhoMap(ListToMap map){
        System.out.println("Tamanho do Map: "+map.size()+"\n");
    }

    public void mapValues(ListToMap map){

        System.out.println("Elementos do MAP: ");

        for(Object s : map.values())
            System.out.println(s);
        System.out.println();
    }

    public void contemChaveMap(ListToMap map, int chave){
        if(map.containsKey(chave))
            System.out.println("O Map contém a chave: "+chave+"\n");
        else
            System.out.println("O Map não contém a chave\n");
    }

    public void contemValorMap(ListToMap map, String valor){
        if(map.containsValue(valor))
            System.out.println("O Map contém o Valor: "+valor+"\n");
        else
            System.out.println("O Map não contém o Valor\n");
    }

    public void isEmptyMap(ListToMap map) {
        if (map.isEmpty()) System.out.println("O Map está vazio.");
        else System.out.println("O Map não está vazio.");
    }

    public void emptyMap(ListToMap map){
        map.clear();
        System.out.println("O Map está vazio\n");
    }
}
