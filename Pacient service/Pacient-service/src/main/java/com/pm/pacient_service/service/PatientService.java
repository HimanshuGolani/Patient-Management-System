package com.pm.pacient_service.service;


import com.pm.pacient_service.dto.request.PatientRequestDto;
import com.pm.pacient_service.dto.response.PatientResponseDto;
import com.pm.pacient_service.dto.response.UpdatePatientResponseDto;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientResponseDto> getPatients();

    PatientResponseDto createPatient(PatientRequestDto patient);

    PatientResponseDto updatePatient(UUID id,PatientRequestDto data);

}
