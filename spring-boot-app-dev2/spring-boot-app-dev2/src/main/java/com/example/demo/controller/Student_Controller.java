package com.example.demo.controller;

import com.example.demo.entity.Login_Request;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class Student_Controller {
    @Autowired
    private StudentService studentService;

    /**
     * Register a new student.
     *
     * @param student The student entity containing registration details.
     * @return ResponseEntity containing the registered student details.
     */
    @PostMapping("/register")
    public ResponseEntity<Student> Register_Student(@RequestBody Student student) {
        Student Registered_Student = studentService.Register_Student(student);
        return ResponseEntity.ok(Registered_Student);
    }

    /**
     * Log in an existing student.
     *
     * @param login_Request The login request containing email and password.
     * @return ResponseEntity containing the logged-in student details or 401 if unauthorized.
     */
    @PostMapping("/login")
    public ResponseEntity<Student> Login(@RequestBody Login_Request login_Request) {
        Student logged_in_Student = studentService.Login(login_Request.getEmail(), login_Request.getPassword());
        if (logged_in_Student != null) {
            return ResponseEntity.ok(logged_in_Student);
        }
        return ResponseEntity.status(401).build();
    }

    /**
     * Retrieves all students.
     *
     * @return ResponseEntity with the list of all students.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

//    @PutMapping("/update/{id}/name")
//    public ResponseEntity<Student> updateStudentName(@PathVariable Long id, @RequestParam String name)
//    {
//        try
//        {
//            Student updateStudent = studentService.updateStudentName(id, name);
//            return new ResponseEntity<>(updateStudent, HttpStatus.OK);
//        }  catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("/update/{id}/surname")
//    public ResponseEntity<Student> updateStudentSurname(@PathVariable Long id, @RequestParam String surname)
//    {
//        try{
//            Student updateStudent = studentService.updateStudentSurname(id, surname);
//            return new ResponseEntity<>(updateStudent, HttpStatus.OK);
//        }  catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    /**
     * Update the name of an existing student.
     *
     * @param id             The ID of the student to update.
     * @param updatedStudent The student entity containing the new name.
     * @return ResponseEntity containing the updated student details or 404 if not found.
     */
    @PutMapping("/update/{id}/name")
    public ResponseEntity<Student> updateStudentName(@PathVariable Long id, @RequestBody Student updatedStudent) {
        try {
            Student updateStudent = studentService.updateStudentName(id, updatedStudent.getName());
            return new ResponseEntity<>(updateStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update the surname of an existing student.
     *
     * @param id             The ID of the student to update.
     * @param updatedStudent The student entity containing the new surname.
     * @return ResponseEntity containing the updated student details or 404 if not found.
     */
    @PutMapping("/update/{id}/surname")
    public ResponseEntity<Student> updateStudentSurname(@PathVariable Long id, @RequestBody Student updatedStudent) {
        try {
            Student updateStudent = studentService.updateStudentSurname(id, updatedStudent.getSurname());
            return new ResponseEntity<>(updateStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("/update/{id}/password")
//    public ResponseEntity<Student> updateStudentPassword(@PathVariable Long id, @RequestParam String password)
//    {
//        try{
//            Student updatedStudent = studentService.updateStudentPassword(id, password);
//            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
//        } catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    /**
     * Update the password of an existing student.
     *
     * @param id   The ID of the student to update.
     * @param body A map containing the new password.
     * @return ResponseEntity containing the updated student details or 404 if not found.
     */
    @PutMapping("/update/{id}/password")
    public ResponseEntity<Student> updateStudentPassword(@PathVariable Long id, @RequestBody Map<String, String> body) {
        try {
            String newPassword = body.get("password"); // Extract the password from JSON body
            Student updatedStudent = studentService.updateStudentPassword(id, newPassword);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK); // Return the updated student
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle not found case
        }
    }
}
