package com.commands;

import com.DBConfig.HibernateUtil;
import com.repository.StudentRepository;
import com.repository.SubjectRepository;
import com.service.StudentService;
import com.service.SubjectService;

public class SummaryGrades implements Command{

    private final static SubjectService SUBJECT_SERVICE = new SubjectService(new SubjectRepository(HibernateUtil.getEntityManager()));
    @Override
    public void execute() {
        SUBJECT_SERVICE.subjectScores();
        Menu.printMenu(Commands.values());
    }
}
