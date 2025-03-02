package org.example.Adapters;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.Assert.*;

public class MapToListTest {
    MapToList list;

    @Before
    public void setup(){
        list = new MapToList(new HashMap<Integer, String>());

        list.add("Gustavo");
        list.add("Calebe");
        list.add("Werlys");
        list.add("Victor");
        list.add("Matheus");
        list.add("Vinicius");
    }

    @Test
    public void testeAdd(){
        list.add("Luiz");
    }

    @Test
    public void testeAddIndex(){
        list.add(6,"Zayon");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testeIndexOutOfBounds(){
        list.add(20, "Thomas");
    }

    @Test
    public void testeIndexJaExsitente(){
        list.add(3,"Vitor");
    }

    @Test
    public void testeIterator(){
        Iterator it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}