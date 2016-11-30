package com.epam.suleimenov.DAO;

import java.util.List;

public interface GenericDAO<T> {

    List<T> getList();
    void save(T object);
    void delete(T object);
    T findById(Integer id);
    T update(T object);
}
