package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define the endpoints from /students - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> theStudent = new ArrayList<>();
        theStudent.add(new Student("Winston","Bishop"));
        theStudent.add(new Student("Cece","Parekh"));
        theStudent.add(new Student("Nick","Miller"));
        theStudent.add(new Student("Spencer","Hastings"));

        return theStudent;
    }

}
