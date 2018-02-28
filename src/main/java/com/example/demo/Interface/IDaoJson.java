package com.example.demo.Interface;

import java.util.List;

public interface IDaoJson<E> {

    public List<E> findAll();
    public E findOne(int primaryKey);
    public void save(E e);
    public void delete(E e);

}
