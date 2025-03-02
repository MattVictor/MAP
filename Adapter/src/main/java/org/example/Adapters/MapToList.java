package org.example.Adapters;

import java.util.*;

public class MapToList implements List {
    // Só funciona para maps com chaves de inteiros (ou floats).
    private Map map;

    public MapToList(Map antigoMap){
        this.map = antigoMap;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsValue(o);
    }

    @Override
    public Object[] toArray() {
        return map.values().toArray();
    }

    @Override
    public boolean add(Object o) {
        map.put(map.size(),o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(map.containsKey(o)){
            map.remove(o);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object get(int index) {
        return map.get(index);
    }

    @Override
    public void add(int index, Object element){

        if (index < 0 || index > map.size()) {
            throw new IndexOutOfBoundsException();
        }
        
        for (int i=index; i<map.size(); i++) { //tira todos os elementos depois do indice escolhido e recoloca com o indice +1
            Object value = map.get(i);
            map.remove(i);
            map.put(i+1,value);
        }
        map.put(index,element);
    }

    @Override
    public Object remove(int index) {

        if (index < 0 || index > map.size()-1) {
            throw new IndexOutOfBoundsException();
        }
        
        Object obj = map.remove(index); // removendo objeto primeiro
        for (int i=index+1; i<map.size(); i++) { //tira todos os elementos depois do indice escolhido e recoloca com o indice -1
            Object value = map.get(i);
            map.remove(i);
            map.put(i-1,value);
        }
        return obj;
    }

    @Override
    public Iterator iterator() {
        return map.values().iterator();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return this.map.values().toArray();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }
}
