package com;


import com.DBConfig.FlywayConfig;
import com.commands.Commands;
import com.commands.Menu;
import org.flywaydb.core.Flyway;
public class Main {


    public static void main(String[] args) {
        Flyway flyway = FlywayConfig.configure();
        flyway.migrate();
        Menu.printMenu(Commands.values());
    }


}
