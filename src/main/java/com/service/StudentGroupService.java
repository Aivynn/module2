package com.service;

import com.model.StudentGroup;
import com.repository.StudentGroupRepository;

import java.util.List;

public class StudentGroupService {

    private final StudentGroupRepository repository;

    public StudentGroupService(StudentGroupRepository repository) {
        this.repository = repository;
    }

    public void saveGroup(StudentGroup group) {
        repository.save(group);
    }

    public List<StudentGroup> findByName(String name){
        return repository.findByName(name);
    }

    public void studentQuantity(){
        repository.studentQuantity();
    }
    public void studentAverageGrades(){
        repository.averageGrade();
    }


}
