package com.example.resolver;

import com.example.domain.Address;
import com.example.domain.Student;
import graphql.kickstart.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AddressResolver implements GraphQLResolver<Student> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressResolver.class);

    public Address address(Student student) {
        return Address.builder("Haryana")
                .city("Samalkha")
                .zip("132122")
                .build();
    }
}
