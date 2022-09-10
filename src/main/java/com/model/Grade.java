package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Entity
@NoArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    protected String id;

    @OneToOne
    private Subject subjectName;

    @OneToOne
    private Student student;

    private int value;

    public Grade(Subject subject, Student student, int value) {
        this.subjectName = subject;
        this.student = student;
        this.value = value;
    }

}
