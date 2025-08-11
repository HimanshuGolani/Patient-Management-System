package com.pm.pacient_service.util.validator;

public class ValidatorFactory {
    public static Validator<?> getInstance(ValidatorTypes type) {
        return switch (type) {
            case PatientInputTextValidator -> new PatientInputTextValidator();
            case InputFileValidator -> new InputFileValidator();
        };
    }
}
