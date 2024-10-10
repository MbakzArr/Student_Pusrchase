package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Student Register_Student(Student student)
    {
        student.setStudent_Password(encoder.encode(student.getStudent_Password()));
        return studentRepository.save(student);
    }

    public Student Login(String Student_Email, String student_Password)
    {
        Student student = studentRepository.findByEmail(Student_Email);
        if(student != null && encoder.matches(student_Password, student.getStudent_Password()))
        {
            return student;
        }
        return null;
    }
}
