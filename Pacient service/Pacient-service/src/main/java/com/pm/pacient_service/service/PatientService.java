package com.pm.pacient_service.service;


import com.pm.pacient_service.dto.request.PatientRequestDto;
import com.pm.pacient_service.dto.response.PatientResponseDto;

import java.util.List;

public interface PatientService {

    List<PatientResponseDto> getPatients();

    PatientResponseDto createPatient(PatientRequestDto patient);

}
