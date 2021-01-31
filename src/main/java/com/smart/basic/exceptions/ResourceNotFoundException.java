package com.smart.basic.exceptions;

import javassist.NotFoundException;

public class ResourceNotFoundException extends NotFoundException {
    public ResourceNotFoundException(String s){
        super("Employee not found");
    }


}
