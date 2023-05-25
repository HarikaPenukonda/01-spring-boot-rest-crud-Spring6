package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    // define @PostConstruct to load the student data... only once
    @PostConstruct // only load student data once
    public void loadData(){

        theStudent = new ArrayList<>();
        theStudent.add(new Student("Winston","Bishop"));
        theStudent.add(new Student("Cece","Parekh"));
        theStudent.add(new Student("Nick","Miller"));
        theStudent.add(new Student("Spencer","Hastings"));

    }

    // define the endpoints from /students - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudent;
    }

}
