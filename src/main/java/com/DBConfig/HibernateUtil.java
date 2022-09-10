package com.DBConfig;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private HibernateUtil() {
    }

    private final static String URL = System.getenv("URL");
    private final static String USER = System.getenv("USER");
    private final static String PASSWORD = System.getenv("PASSWORD");

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        HashMap<String,String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", URL);
        properties.put("javax.persistence.jdbc.user", USER);
        properties.put("javax.persistence.jdbc.password", PASSWORD);
        if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("model",properties).createEntityManager();
            entityManager.unwrap(Session.class);
        }
        return entityManager;
    }

}