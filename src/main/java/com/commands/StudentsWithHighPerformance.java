package com.commands;

import com.DBConfig.HibernateUtil;
import com.model.Student;
import com.repository.StudentRepository;
import com.service.StudentService;

import java.util.List;

public class StudentsWithHighPerformance implements Command {

    private final static StudentService STUDENT_SERVICE = new StudentService(new StudentRepository(HibernateUtil.getEntityManager()));
    @Override
    public void execute() {
        System.out.println("Enter the number to show students with grades higher");
        try {
            int value = SCANNER.nextInt();
            List<Student> studentList = STUDENT_SERVICE.findByGrade(value);
            studentList.forEach(System.out::println);

        }
        catch (Exception e) {
            throw new ArithmeticException("You entered not a number, try again");
        }
        Menu.printMenu(Commands.values());
    }
}
