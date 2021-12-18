package com.example.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private final Class aClass;
    private final Integer id;

    public ResourceNotFoundException(Class aClass, Integer id) {
        this.aClass = aClass;
        this.id = id;
    }

    @Override
    public String getMessage() {
        String resourceClassName = aClass.getSimpleName();
        String message = " not found with Given id:: ";
        return resourceClassName + message + id;
    }
}
