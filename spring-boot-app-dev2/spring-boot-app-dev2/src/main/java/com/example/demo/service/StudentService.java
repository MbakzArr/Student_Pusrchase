package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class to handle Student-related operations.
 */
@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    // BCrypt password encoder with strength 12
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    /**
     * Registers a new student by encoding their password and saving them in the repository.
     *
     * @param student The student object to be registered.
     * @return The registered student.
     */
    public Student Register_Student(Student student)
    {
        student.setPassword(encoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    /**
     * Retrieves all registered students.
     *
     * @return List of all students.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll(); // Fetch all students from the repository
    }

    /**
     * Logs in a student by verifying their email and password.
     *
     * @param Student_Email The email of the student.
     * @param student_Password The plain-text password provided by the student.
     * @return The student if login is successful, or null if authentication fails.
     */
    public Student Login(String Student_Email, String student_Password)
    {
        Student student = studentRepository.findByEmail(Student_Email);
        if(student != null && encoder.matches(student_Password, student.getPassword()))
        {
            return student;
        }
        return null;
    }

    /**
     * Updates a student's name by their ID.
     *
     * @param id The student's ID.
     * @param name The new name for the student.
     * @return The updated student object.
     * @throws Exception if the student with the given ID is not found.
     */
    public Student updateStudentName(Long id, String name) throws Exception
    {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent())
        {
            Student student = optionalStudent.get();
            student.setName(name);
            return studentRepository.save(student);
        }  else{
            throw new Exception("Student not found");
        }
    }

    /**
     * Updates a student's surname by their ID.
     *
     * @param id The student's ID.
     * @param surname The new surname for the student.
     * @return The updated student object.
     * @throws Exception if the student with the given ID is not found.
     */
    public Student updateStudentSurname(Long id, String surname) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent())
        {
            Student student = optionalStudent.get();
            student.setSurname(surname);
            return studentRepository.save(student);
        } else {
            throw new Exception("Student no found!");
        }
    }


    /**
     * Updates a student's password by their ID.
     *
     * @param id The student's ID.
     * @param newPassword The new plain-text password to be encoded and saved.
     * @return The updated student object.
     * @throws Exception if the student with the given ID is not found.
     */
    public Student updateStudentPassword(Long id, String newPassword) throws Exception
    {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();

            String encodePassword = encoder.encode(newPassword);
            student.setPassword(encodePassword);
            return studentRepository.save(student);
        } else {
            throw new Exception("Student not found!");
        }
    }
}
