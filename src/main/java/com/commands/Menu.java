package com.commands;

import static com.commands.Command.SCANNER;

public class Menu{
        public static boolean printMenu(final Commands[] values){

        int userCommand = -1;
        do {
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d) %s%n", i, values[i].getString());
            }
            int input = SCANNER.nextInt();
            if (input >= 0 && input < values.length) {
                userCommand = input;
            }
        } while (userCommand == -1);
        final Command command;
        command = values[userCommand].getCommand();
        if (command == null) {
            return true;
        } else {
            command.execute();
            return false;
        }
    }
}
