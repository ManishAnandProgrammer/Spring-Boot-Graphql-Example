package com.example;

import com.example.domain.Student;
import com.example.service.StudentService;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootGraphqlApplication {

	private final StudentService studentService;
	private final Faker faker;

	public SpringBootGraphqlApplication(final StudentService studentService, Faker faker) {
		this.studentService = studentService;
		this.faker = faker;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void fillStudents() {
		IntStream.range(1, 200).forEach(value -> {
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
