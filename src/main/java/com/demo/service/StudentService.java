package com.demo.service;

import com.breatheout.tables.Student;
import com.demo.response.StudentResponse;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final DSLContext dslContext;

  public List<StudentResponse> getStudents() {
    List<StudentResponse> studentResponseList = dslContext.select(Student.STUDENT.ID, Student.STUDENT.NAME, Student.STUDENT.START_DATE,
          Student.STUDENT.END_DATE).from(Student.STUDENT).fetch().into(StudentResponse.class);
    return studentResponseList;

  }
}
