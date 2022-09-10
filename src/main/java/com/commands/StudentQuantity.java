package com.commands;

import com.DBConfig.HibernateUtil;
import com.repository.StudentGroupRepository;
import com.service.StudentGroupService;

public class StudentQuantity implements Command{

    private final static StudentGroupService GROUP_SERVICE = new StudentGroupService(new StudentGroupRepository(HibernateUtil.getEntityManager()));

    @Override
    public void execute() {
        GROUP_SERVICE.studentQuantity();
        Menu.printMenu(Commands.values());
    }
}
