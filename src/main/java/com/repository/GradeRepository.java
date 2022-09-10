package com.repository;

import com.model.Grade;
import javax.persistence.EntityManager;

public class GradeRepository {

    private final EntityManager entityManager;

    public GradeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Grade grade) {
        entityManager.getTransaction().begin();
        entityManager.persist(grade);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }
}
