package com.example.service;

import com.example.domain.Student;
import com.example.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(Integer id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(Student.class, id));
    }

    public Student save(Student student) {
        student.setId(idCounter.incrementAndGet());
        students.add(student);
        return student;
    }
}
