package com.example.resolver.mutation;

import com.example.domain.Student;
import com.example.service.StudentService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
@Validated
public class StudentMutationResolver implements GraphQLMutationResolver {
    private final StudentService studentService;

    public StudentMutationResolver(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student saveStudent(@Valid Student payload) {
        return studentService.save(payload);
    }
}
