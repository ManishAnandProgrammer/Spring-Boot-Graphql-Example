package com.example.resolver;

import com.example.domain.Address;
import com.example.domain.Student;
import graphql.kickstart.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.example.util.Sleep.sleep;

@Component
public class AddressResolver implements GraphQLResolver<Student> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressResolver.class);
    private final ExecutorService executorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public CompletableFuture<Address> address(Student student) {
        return CompletableFuture.supplyAsync(() -> {
                    LOGGER.info("came to fetch address for student {} with thread {}", student.getId(),
                            Thread.currentThread().getName());
                    // to replicate latency
                    // suppose this address coming from
                    // another microservice
                    sleep(20);
                    return Address.builder("Haryana")
                            .city("Samalkha")
                            .zip("132122")
                            .build();
                }, executorService);
    }

//    sync way to do resolver
//    public Address address(Student student) {
//        LOGGER.info("came to fetch address for student {} with thread {}", student.getId(),
//                Thread.currentThread().getName());
//        // to replicate latency
//        // suppose this address coming from
//        // another microservice
//        sleep(20);
//        return Address.builder("Haryana")
//                .city("Samalkha")
//                .zip("132122")
//                .build();
//    }
}
