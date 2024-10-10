package com.example.demo.controller;

import com.example.demo.entity.Login_Request;
import com.example.demo.entity.MerchItem;
import com.example.demo.entity.Student;
import com.example.demo.enums.MerchCategory;
import com.example.demo.service.MerchService;
import com.example.demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merch")
public class MerchItemController
{
    @Autowired
    private MerchService merchService;
    private StudentService studentService;

    @GetMapping("/all")
    public List<MerchItem> getAllMerchItems()
    {
        return merchService.getAllMerchItems();
    }

    @PostMapping("/create")
    public MerchItem createMerchItem(@RequestBody MerchItem merchItem)
    {
        return merchService.createMerchItem(merchItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MerchItem> getMerchItemById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException
    {
        MerchItem merchItem = merchService.getMerchItemById(id);
        return new ResponseEntity<>(merchItem, HttpStatus.OK); //200,201,400,404,500
    }

    @GetMapping("/category")
    public List<MerchItem> getMerchItemsByCategory(MerchCategory category)
    {
        return merchService.getAllMerchByCategory(category);
    }

//    @PostMapping("/register")
//    public ResponseEntity<Student> Register_Student(@RequestBody Student student) {
//        Student Registered_Student = StudentService.Register_Student(student);
//        return ResponseEntity.ok(Registered_Student);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<Student> Login(@RequestBody Login_Request login_Request) {
//        Student logged_in_Student = StudentService.Login(login_Request.getStudent_Email(), login_Request.getStudent_Password());
//        if (logged_in_Student != null)
//        {
//            return ResponseEntity.ok(logged_in_Student);
//        }
//        return ResponseEntity.status(401).build();
//    }

//    @GetMapping("csrf-token")
//    public CsrfToken csrfToken(HttpServletRequest request)
//    {
//        return (CsrfToken) request.getAttribute("_csrf");
//    }
}