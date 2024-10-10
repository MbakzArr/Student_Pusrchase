package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Student entities.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
    /**
     * Finds a Student by their email address.
     *
     * @param email The email address of the student to find.
     * @return The Student object associated with the given email, or null if no student is found.
     */
    Student findByEmail(String email);
}
