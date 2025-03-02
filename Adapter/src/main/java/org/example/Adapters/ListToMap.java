package org.example.Adapters;

import java.util.*;

public class ListToMap implements Map {
    private List list;

    public ListToMap(List lista){
        this.list = lista;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        if(key instanceof Integer) {
            if (list.size() > (Integer) key) {
                return true;
            } else
                return false;
        }else
            throw new IllegalArgumentException();
    }

    @Override
    public boolean containsValue(Object value) {
        return list.contains(value);
    }

    @Override
    public Object get(Object key) {
        if(key instanceof Integer)
            return list.get((int) key);
        else
            throw new IllegalArgumentException();
    }

    @Override
    public Object put(Object key, Object value) {
        if((int) key <= list.size()){
            list.add((int) key,value);
        }else{
            list.add(value);
        }
        return value;
    }

    @Override
    public Object remove(Object key) {
        if(key instanceof Integer)
            return list.remove((int) key);
        else
            throw new IllegalArgumentException();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Collection values() {
        return list;
    }

    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Entry> entrySet() {
        throw new UnsupportedOperationException();
    }
}
