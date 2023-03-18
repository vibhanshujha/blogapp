package com.themechguy.blogapp.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Custom exception extending RuntimeException fpr checked exceptions
@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    Long fieldValue;
    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    

    
}
