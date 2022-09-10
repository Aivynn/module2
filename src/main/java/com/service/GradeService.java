package com.service;

import com.DBConfig.HibernateUtil;
import com.model.Grade;
import com.repository.GradeRepository;

public class GradeService {

    private final GradeRepository repository;


    public GradeService(GradeRepository repository){
        this.repository = repository;
    }

    public void saveGrade(Grade grade){
        repository.save(grade);
    }
}
