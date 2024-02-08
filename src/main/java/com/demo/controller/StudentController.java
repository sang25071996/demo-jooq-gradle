package com.demo.controller;

import com.demo.response.StudentResponse;
import com.demo.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @GetMapping
  public ResponseEntity<List<StudentResponse>> getStudents() {
    return ResponseEntity.ok().body(studentService.getStudents());
  }
}
