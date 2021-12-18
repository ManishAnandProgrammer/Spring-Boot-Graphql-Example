package com.example.resolver;

import com.example.domain.Family;
import com.example.domain.Student;
import com.github.javafaker.Faker;
import graphql.kickstart.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.example.util.Sleep.sleep;

@Component
public class FamilyResolver implements GraphQLResolver<Student> {
    private final static Logger LOGGER = LoggerFactory.getLogger(FamilyResolver.class);
    private final ExecutorService executorService =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private final Faker faker;

    public FamilyResolver(Faker faker) {
        this.faker = faker;
    }

    public CompletableFuture<Family> family(Student student) {
     return CompletableFuture.supplyAsync(() -> {
                sleep(20);
                LOGGER.info("came to fetch family for student {} with thread {}", student.getId(),
                        Thread.currentThread().getName());

                String father = faker.friends().character();
                String mother = faker.friends().character();

                String firstSibling = faker.funnyName().name();
                String secondSibling = faker.funnyName().name();

                Family family = new Family();
                family.setFather(father);
                family.setMother(mother);
                family.setSibling(List.of(firstSibling, secondSibling));

                return family;
        }, executorService);
    }

//    public Family family(Student student){
//        sleep(20);
//        LOGGER.info("came to fetch family for student {} with thread {}", student.getId(),
//                Thread.currentThread().getName());
//
//        String father = faker.friends().character();
//        String mother = faker.friends().character();
//
//        String firstSibling = faker.funnyName().name();
//        String secondSibling = faker.funnyName().name();
//
//        Family family = new Family();
//        family.setFather(father);
//        family.setMother(mother);
//        family.setSibling(List.of(firstSibling, secondSibling));
//
//        return family;
//    }
}
