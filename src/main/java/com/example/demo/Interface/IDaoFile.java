package com.example.demo.Interface;

import java.util.List;

public interface IDaoFile<E> {

    public List<E> findAll();
    public E findOne(int primaryKey);
    public void save(E e);
    public void delete(int i);
    public void save(List<E> e);
    public void edit(E e);

}
