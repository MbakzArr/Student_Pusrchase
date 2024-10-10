package com.example.demo.controller;

import com.example.demo.entity.Login_Request;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class Student_Controller
{
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<Student> Register_Student(@RequestBody Student student) {
        Student Registered_Student = studentService.Register_Student(student);
        return ResponseEntity.ok(Registered_Student);
    }

    @PostMapping("/login")
    public ResponseEntity<Student> Login(@RequestBody Login_Request login_Request) {
        Student logged_in_Student = studentService.Login(login_Request.getEmail(), login_Request.getPassword());
        if (logged_in_Student != null)
        {
            return ResponseEntity.ok(logged_in_Student);
        }
        return ResponseEntity.status(401).build();
    }

//    @GetMapping("csrf-token")
//    public CsrfToken csrfToken(HttpServletRequest request)
//    {
//        return (CsrfToken) request.getAttribute("_csrf");
//    }

}
