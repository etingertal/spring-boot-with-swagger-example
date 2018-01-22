package com.sofusit.poalimbootstrap.excpetion;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String resource) {
        super("Tried to find nonexistent resource: " + resource);
    }
}
