package com.DBConfig;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
    private final static String URL = System.getenv("URL");
    private final static String USER = System.getenv("USER");
    private final static String PASSWORD = System.getenv("PASSWORD");
    public static Flyway configure(){
        return Flyway.configure()
                .dataSource(URL,USER,PASSWORD)
                .schemas("public")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
    }
}
