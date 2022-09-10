package com.repository;

import com.model.Subject;
import com.model.SubjectInfo;
import com.service.SubjectService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SubjectRepository {

    private final EntityManager entityManager;

    public SubjectRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Subject subject) {
        entityManager.getTransaction().begin();
        entityManager.persist(subject);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    public void subjectScores() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("""
                SELECT avg(gr.value) as averageValue, s.name from
                Grade gr LEFT JOIN Subject s on gr.subjectName = s.id
                Group by s.name
                ORDER by averageValue DESC
                """);
        List<Object[]> groups = query.getResultList();
        int worstGrades = groups.size() - 1;
        System.out.println(groups.get(0)[0] + " " + groups.get(0)[1]);
        System.out.println(groups.get(worstGrades)[0] + " " + groups.get(worstGrades)[1]);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

}
