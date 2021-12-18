package com.example;

import com.example.domain.Student;
import com.example.service.StudentService;
import com.github.javafaker.Avatar;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootGraphqlApplication {

	private final StudentService studentService;

	public SpringBootGraphqlApplication(final StudentService studentService) {
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void fillStudents() {
		Faker faker = new Faker();
		IntStream.range(1, 100).forEach(value -> {
			Student student = new Student();
			String fullName = faker.name().fullName();
			student.setName(fullName);
			String phoneNumber = faker.phoneNumber().phoneNumber();
			student.setPhone(phoneNumber);
			student.setRollNo(value);
			studentService.save(student);
		});
	}
}
