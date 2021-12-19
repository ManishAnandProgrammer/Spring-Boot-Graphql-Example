package com.example.exceptions;

import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@Component
public class GraphqlExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphqlExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError handleRuntimeException(RuntimeException runtimeException) {
        LOGGER.error("Internal Runtime Exception:: ", runtimeException);
        return new ThrowableGraphQLError(runtimeException, "Internal Server Error");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ThrowableGraphQLError handleResourceNotFoundException
            (ResourceNotFoundException resourceNotFoundException) {
        LOGGER.info(resourceNotFoundException.getMessage());
        return new ThrowableGraphQLError(resourceNotFoundException);
    }

    @ExceptionHandler(FileSizeLimitExceededException.class)
    public ThrowableGraphQLError handleIt(FileSizeLimitExceededException exception) {
        LOGGER.error("File Exception:: ", exception);
        return new ThrowableGraphQLError(exception);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ThrowableGraphQLError handleIt(IllegalStateException exception) {
        LOGGER.error("File Exception:: ", exception);
        return new ThrowableGraphQLError(exception);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ThrowableGraphQLError handleIt(ConstraintViolationException exception) {
        return new ThrowableGraphQLError(exception);
    }

}
