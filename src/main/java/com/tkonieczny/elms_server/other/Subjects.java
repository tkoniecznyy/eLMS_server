package com.tkonieczny.elms_server.other;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.ArrayList;
@ToString
@Getter
@NoArgsConstructor
public class Subjects {
    Integer idOfSubject;
    String nameOfSubject;

    public Subjects(Integer idOfSubject, String nameOfSubject) {
        this.idOfSubject = idOfSubject;
        this.nameOfSubject = nameOfSubject;
    }

    public static Subjects sub1 = new Subjects(1,"Matematyka");
    public static Subjects sub2 = new Subjects(2,"Biologia");
    public static Subjects sub3 = new Subjects(3,"Chemia");
    public static Subjects sub4 = new Subjects(4,"Jezyk polski");


}

