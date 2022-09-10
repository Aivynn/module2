package com.repository;

import com.model.StudentGroup;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;

public class StudentGroupRepository {

    private final EntityManager entityManager;

    public StudentGroupRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(StudentGroup studentGroup) {
        entityManager.getTransaction().begin();
        entityManager.persist(studentGroup);
        entityManager.getTransaction().commit();
    }


    public List<StudentGroup> findByName(String name) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from StudentGroup where name like :name");
        query.setParameter("name", "%" + name + "%");
        List<StudentGroup> groups = query.getResultList();
        entityManager.flush();
        entityManager.getTransaction().commit();
        return groups;
    }

    public void studentQuantity() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("""
                SELECT count(s.groupId) as count, gr.name
                FROM
                Student as s LEFT JOIN StudentGroup as gr ON gr.id = s.groupId
                Group by gr.name
                """);
        List<Object[]>groups = query.getResultList();
        groups.forEach(x -> {
            System.out.println(x[1] + " : " + x[0]);
        });
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    public void averageGrade(){
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("FIND_AVG_GRADE");
        List<Object[]> groups = query.getResultList();
        groups.forEach(x -> {
            System.out.println(x[2] + " : " + x[0]);
        });
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

}
