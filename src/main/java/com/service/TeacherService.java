package com.service;

import com.model.Subject;
import com.model.Teacher;
import com.repository.TeacherRepository;
import com.util.SimpleNameGenerator;

import java.util.List;
import java.util.Random;

public class TeacherService {

    private final TeacherRepository repository;


    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    private final Random random = new Random();

    protected Teacher createTeacher(Subject subject) {
        return new Teacher(
                SimpleNameGenerator.generateName(),
                SimpleNameGenerator.generateName(),
                random.nextInt(18,65),
                subject

        );
    }

    public List<Teacher> findByLastName(String name){
        return repository.findByLastName(name);
    }
    }
