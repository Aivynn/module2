package com.model;

import lombok.ToString;

import javax.persistence.MappedSuperclass;

@ToString
@MappedSuperclass
public class SubjectInfo {


    private int value;

    private String name;

    SubjectInfo(){

    }
}
