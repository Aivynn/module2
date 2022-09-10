package com.model;


import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
public class Teacher extends Human {

    @OneToOne
    private Subject subject;


    public Teacher(String firstName, String lastName, int age,Subject subject) {
        super(firstName, lastName, age);
        this.subject = subject;
    }

}
