package com.commands;

import lombok.Getter;

@Getter
public enum Commands {
    SubjectGrades("Summary grade statistic for subject", new SummaryGrades()),
    TeacherName("Searching teacher's last name", new TeacherName()),
    GroupName("Searching group by name", new GroupName()),
    StudentQuantity("Info group's students quantity on it", new StudentQuantity()),
    GroupAcademicPerformance("Info about group's summary grade statistic", new GroupPerformance()),
    HighPerformanceStudents("Searching students with high academic performance", new StudentsWithHighPerformance()),
    EXIT("Exit", null);

    private final String string;
    private final Command command;

    Commands(String string, Command command) {
        this.string = string;
        this.command = command;

    }
}
