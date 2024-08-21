package com.web.application.designpattern;

import java.util.ArrayList;
import java.util.List;

public class StudentBO {

    //list is working as a database
    List<StudentVO> students;

    public StudentBO(){
        students = new ArrayList<>();
        StudentVO student1 = new StudentVO("Robert",0);
        StudentVO student2 = new StudentVO("John",1);
        students.add(student1);
        students.add(student2);
    }

    //retrive list of students from the database
    public List<StudentVO> getAllStudents() {
        return students;
    }

    public void updateStudent(StudentVO student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo() +", updated in the database");
    }

    public StudentVO getStudent(int rollNo) {
        return students.get(rollNo);
    }
}
