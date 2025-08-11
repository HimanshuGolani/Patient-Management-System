package com.pm.pacient_service.util.validator;

import java.io.File;

public class InputFileValidator implements Validator<File> {
    @Override
    public boolean validate(File input) {
        return false;
    }
}
