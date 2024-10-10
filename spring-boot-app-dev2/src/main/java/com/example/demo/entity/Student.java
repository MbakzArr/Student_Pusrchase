package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_table")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Student_ID;

    @Column(name = "student_name")
    private String Student_Name;
    private String Student_Surname;
    private String email;
    private String phone;
    private String student_Password;

    public Student()
    {}

    public Student(Long student_ID, String student_Name, String student_Surname, String email, String phone, String student_Password) {
        Student_ID = student_ID;
        Student_Name = student_Name;
        Student_Surname = student_Surname;
        this.email = email;
        this.phone = phone;
        this.student_Password = student_Password;
    }

    public Long getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(Long student_ID) {
        Student_ID = student_ID;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getStudent_Surname() {
        return Student_Surname;
    }

    public void setStudent_Surname(String student_Surname) {
        Student_Surname = student_Surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudent_Password() {
        return student_Password;
    }

    public void setStudent_Password(String student_Password) {
        this.student_Password = student_Password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
