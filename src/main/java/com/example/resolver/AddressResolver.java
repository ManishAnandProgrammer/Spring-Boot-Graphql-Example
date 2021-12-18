package com.example.resolver;

import com.example.domain.Address;
import com.example.domain.Student;
import graphql.kickstart.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.example.util.Sleep.sleep;

@Component
public class AddressResolver implements GraphQLResolver<Student> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressResolver.class);

    public Address address(Student student) {
        LOGGER.info("came to fetch address for student {} with thread {}", student.getId(),
                Thread.currentThread().getName());
        // to replicate latency
        // suppose this address coming from
        // another microservice
        sleep(50);
        return Address.builder("Haryana")
                .city("Samalkha")
                .zip("132122")
                .build();
    }
}
