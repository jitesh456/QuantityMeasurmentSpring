package com.example.quantitymeasurment.exception;

public class QuantityMeasurementException extends RuntimeException {
    public final ExceptionType type;

   public enum ExceptionType{
        INVALID_UNIT_TYPE;
    }

    public QuantityMeasurementException(String message,ExceptionType type) {
        super(message);
        this.type=type;
    }
}
