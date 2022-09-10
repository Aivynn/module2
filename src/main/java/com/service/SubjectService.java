package com.service;

import com.DBConfig.HibernateUtil;
import com.model.Subject;
import com.repository.SubjectRepository;

public class SubjectService {
    private final SubjectRepository repository;


    public SubjectService(SubjectRepository repository){
        this.repository = repository;
    }

    public void saveSubject(Subject subject){
        repository.save(subject);
    }

    public void subjectScores(){
        repository.subjectScores();
    }
}
