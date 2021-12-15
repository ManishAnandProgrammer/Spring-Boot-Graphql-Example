package com.example.resolver;

import com.example.domain.Student;
import com.example.service.StudentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentQueryResolver implements GraphQLQueryResolver {
    private final StudentService studentService;

    public StudentQueryResolver(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    public Student getStudent(Integer id) {
        return studentService.getStudentById(id);
    }
}
