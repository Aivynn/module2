package com.commands;

import com.DBConfig.HibernateUtil;
import com.repository.StudentGroupRepository;
import com.service.StudentGroupService;

public class GroupPerformance implements Command{

    private final static StudentGroupService GROUP_SERVICE = new StudentGroupService(new StudentGroupRepository(HibernateUtil.getEntityManager()));

    @Override
    public void execute() {
        GROUP_SERVICE.studentAverageGrades();
        Menu.printMenu(Commands.values());
    }
}
