package com.example.configuration;

import graphql.Scalars;
import graphql.scalars.ExtendedScalars;
import graphql.scalars.numeric.NonNegativeIntScalar;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalarsConfig {

    @Bean
    public GraphQLScalarType nonNegativeIntScalar() {
        return ExtendedScalars.NonNegativeInt;
    }
}
