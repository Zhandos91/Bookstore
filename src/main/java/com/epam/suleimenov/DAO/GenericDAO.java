package com.epam.suleimenov.DAO;

import java.util.List;

public interface GenericDAO<T> {

    List<T> getList();
    T save(T object);
    boolean remove(T object);
    T fetchById(Integer id);
    T add(T object);
}
