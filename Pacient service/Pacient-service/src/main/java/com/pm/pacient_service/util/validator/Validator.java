package com.pm.pacient_service.util.validator;

public interface Validator<T> {
    boolean validate(T input);
}
