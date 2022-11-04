package com.hospital.exception;

public class PharmacyServiceException extends RuntimeException{

    private static final long serialVersionUID = 7383563257142334439L;

    public PharmacyServiceException(String message)
    {
        super(message);
    }
}
