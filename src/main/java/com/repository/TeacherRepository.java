package com.repository;

import com.model.Teacher;
import org.hibernate.criterion.CriteriaQuery;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TeacherRepository implements SimpleRepository<Teacher> {
    private final EntityManager entityManager;

    public TeacherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void saveAll(List<Teacher> teachers) {
        entityManager.getTransaction().begin();
        for (Teacher teacher : teachers) {
            entityManager.persist(teacher);
        }
        entityManager.getTransaction().commit();
    }

    public List<Teacher> findByLastName(String name) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Teacher where lastName =: i ");
        query.setParameter("i", name);
        List<Teacher> teachers = query.getResultList();
        entityManager.flush();
        entityManager.getTransaction().commit();
        return teachers;

    }
}
