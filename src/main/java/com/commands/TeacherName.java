package com.commands;

import com.DBConfig.HibernateUtil;
import com.model.Teacher;
import com.repository.TeacherRepository;
import com.service.TeacherService;

import java.util.List;

public class TeacherName implements Command{

    private final static TeacherService TEACHER_SERVICE = new TeacherService(new TeacherRepository(HibernateUtil.getEntityManager()));
    @Override
    public void execute() {
        System.out.println("Enter teacher's last name");
        String lastName = SCANNER.next();
        List<Teacher> teacherList = TEACHER_SERVICE.findByLastName(lastName);
        teacherList.forEach(System.out::println);
        Menu.printMenu(Commands.values());
    }
}
