package com.example.demo.entity;

import jakarta.persistence.*;

/**
 * Represents a Student entity for the application.
 */
@Entity
@Table(name = "Student_table")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Student_ID;

    @Column(name = "student_name")
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;

    /**
     * Default constructor for JPA.
     */
    public Student()
    {}

    /**
     * Constructs a new Student instance with the specified details.
     *
     * @param student_ID The unique identifier for the student.
     * @param name The name of the student.
     * @param surname The surname of the student.
     * @param email The email address of the student.
     * @param phone The phone number of the student.
     * @param password The password for the student account.
     */
    public Student(Long student_ID, String name,
                   String surname, String email, String phone,
                   String password) {
        Student_ID = student_ID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Getters and setters

    /**
     * Returns the unique identifier for the student.
     *
     * @return the student ID.
     */
    public Long getStudent_ID() {
        return Student_ID;
    }

    /**
     * Sets the unique identifier for the student.
     *
     * @param student_ID The student ID to set.
     */
    public void setStudent_ID(Long student_ID) {
        Student_ID = student_ID;
    }

    /**
     * Returns the name of the student.
     *
     * @return the student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the surname of the student.
     *
     * @return the student's surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the student.
     *
     * @param surname The surname to set.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the email address of the student.
     *
     * @return the student's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the password of the student.
     *
     * @return the student's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the student.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the phone number of the student.
     *
     * @return the student's phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the student.
     *
     * @param phone The phone number to set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
