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

    public List<Student> findByGrade(double sum) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("Select avg(gr.value), s.* " +
                "from grade as gr LEFT JOIN Student as s on gr.student_id = s.id\n" +
                "Group by s.id Having avg(gr.value) > ?", Student.class);
        query.setParameter(1,sum);
        List<Student> students = query.getResultList();
        entityManager.flush();
        entityManager.getTransaction().commit();
        return students;
    }
}
