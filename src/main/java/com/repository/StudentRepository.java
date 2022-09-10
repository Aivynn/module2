package com.repository;

import com.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentRepository implements SimpleRepository<Student> {
    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public void saveAll(List<Student> students) {
        entityManager.getTransaction().begin();
        for(Student student : students) {
            entityManager.persist(student);
        }
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
    }

    public void findStudentWithHighestGrades(){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("""
                SELECT avg(gr.value) as averageValue, s.lastName from
                Grade gr LEFT JOIN Student s on gr.student = s.id
                Group by s.lastName
                ORDER by averageValue DESC
                """);
        List groups = query.getResultList();
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void findByGrade(double sum) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("Select avg(gr.value), s.firstName, s.lastName, s.id " +
                "from grade as gr LEFT JOIN Student as s on gr.student_id = s.id\n" +
                "Group by s.id Having avg(gr.value) > ?" +
                "Order by avg(gr.value) DESC");
        query.setParameter(1,sum);
        List<Object[]> students = query.getResultList();
        students.forEach(x -> {
            System.out.println(x[1] + " " + x[2] + " " + x[0]);
        });
        entityManager.flush();
        entityManager.getTransaction().commit();
    }
}
