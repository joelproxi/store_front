package org.proxidev.productservice.handleException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private final String fieldName;
    private final Object fieldValue;
    private final String resourceName;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        // Category avec id: 22 est n'existe pas
        super(String.format("%s with field %s: %s not found.", resourceName, fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.resourceName = resourceName;
    }


    public String getFieldName() {
        return this.fieldName;
    }

    public Object getFieldValue() {
        return this.fieldValue;
    }

    public String getResourceName() {
        return this.resourceName;
    }
}
