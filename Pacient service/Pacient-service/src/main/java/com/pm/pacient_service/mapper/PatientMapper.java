package com.pm.pacient_service.mapper;

import com.pm.pacient_service.dto.request.PatientRequestDto;
import com.pm.pacient_service.dto.response.PatientResponseDto;
import com.pm.pacient_service.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDto toDto(Patient patient){
        return new PatientResponseDto(
                patient.getId().toString(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth().toString()
        );
    }
    public static Patient toEntity(PatientRequestDto patient){
                Patient data =  new Patient();
                data.setName(patient.getName());
                data.setEmail(patient.getEmail());
                data.setAddress(patient.getAddress());
                data.setDateOfBirth(LocalDate.parse(patient.getDateOfBirth()));
                return data;
    }
}
