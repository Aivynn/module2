package com.repository;

import com.model.Human;

import java.util.List;

public interface SimpleRepository<T extends Human> {
    public void save(T t);
    public void saveAll(List<T> people);
}
