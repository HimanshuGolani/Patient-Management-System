package com.pm.pacient_service.dto.request;

import com.pm.pacient_service.util.validator.WordCount;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientRequestDto {

    @NotBlank(message = "Name is required")
    @Size(max = 100 , message = "THe name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please fill an valid email")
    private String email;

    @NotBlank(message = "Address is required")
    @WordCount( min = 5, max = 200, message = "The address cannot be exceeding 200 words nor less than 5 words.")
    private String address;

    @NotBlank
    private String dateOfBirth;

}
