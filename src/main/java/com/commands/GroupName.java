package com.commands;

import com.DBConfig.HibernateUtil;
import com.model.StudentGroup;
import com.repository.StudentGroupRepository;
import com.service.StudentGroupService;

import java.util.List;

public class GroupName implements Command{

    private final static StudentGroupService GROUP_SERVICE = new StudentGroupService(new StudentGroupRepository(HibernateUtil.getEntityManager()));
    @Override
    public void execute() {
        System.out.println("Enter the group name or it's digits");
        String name = SCANNER.next();
        List<StudentGroup> groupList = GROUP_SERVICE.findByName(name);
        groupList.forEach(System.out::println);
        Menu.printMenu(Commands.values());
    }
}
