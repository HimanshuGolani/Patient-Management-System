package com.pm.pacient_service.util.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WordCountValidator implements ConstraintValidator<WordCount, String> {

    private int min;
    private int max;

    @Override
    public void initialize(WordCount constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Null values are considered valid and should be handled by @NotNull
        if (value == null) {
            return true;
        }

        // Count words by splitting on whitespace
        String[] words = value.trim().split("\\s+");

        // Handle empty string case
        int wordCount = value.trim().isEmpty() ? 0 : words.length;

        return wordCount >= min && wordCount <= max;
    }
}