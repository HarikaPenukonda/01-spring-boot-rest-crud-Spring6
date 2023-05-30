package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // define endpoint pr "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // just index into the list... keep it simple for now

        // check the studentId again list size
        if ((studentId >= theStudent.size()) || studentId<0){
            throw new StudentNotFoundException("Student Id not found " + studentId);
        }
        return theStudent.get(studentId); // Use StudentId for the index
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse>handleException(StudentNotFoundException e){

        // create a studentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }










}
