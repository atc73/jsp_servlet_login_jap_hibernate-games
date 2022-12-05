package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    List<T> getAll();

    Optional<T> findById(Long id);

    void save(T t);

    void update(T t);

    void delete(T t);

}
