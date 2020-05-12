package com.slmanju.springbootbasic.core;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public class ResourceNotFoundException extends RuntimeException {

    private Integer resourceId;

    public ResourceNotFoundException(Integer resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }

    public static ResourceNotFoundException newInstance(Integer resourceId, String message) {
        return new ResourceNotFoundException(resourceId, message);
    }

}
