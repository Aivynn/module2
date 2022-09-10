package com.service;

import com.model.Student;
import com.repository.SimpleRepository;
import com.repository.StudentRepository;
import com.util.SimpleNameGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StudentService extends SimpleService<Student>{

    private final Random random = new Random();
    private final StudentRepository repository;


    public StudentService(SimpleRepository<Student> repository) {
        super(repository);
        this.repository = (StudentRepository) repository;
    }

    @Override
    public List<Student> createAndSavePeople(int count) {
        {

            if (count <= 0) {
                throw new IllegalArgumentException("Count can't be less then zero");
            }
            List<Student> products = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                final Student student = createPerson();
                products.add(student);
            }
            return products;
        }
    }
    protected Student createPerson() {
        Student student = new Student(
               SimpleNameGenerator.generateName(),
               SimpleNameGenerator.generateName(),
               random.nextInt(18,60)
       );
        repository.save(student);
        return student;
    }

    public void findStudentWithHighestGrades(){
        repository.findStudentWithHighestGrades();
    }

    public List<Student> findByGrade(double sum){
        return repository.findByGrade(sum);
    }
}
