package com.service;

import com.model.Human;
import com.repository.SimpleRepository;

import java.util.List;

public abstract class SimpleService<T extends Human> {

    private final SimpleRepository<T> repository;

    public SimpleService(SimpleRepository<T> repository) {
        this.repository = repository;
    }

    protected abstract List<T> createAndSavePeople(int count) ;


}
