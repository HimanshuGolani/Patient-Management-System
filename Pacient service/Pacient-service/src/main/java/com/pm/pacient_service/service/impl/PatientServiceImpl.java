package com.pm.pacient_service.service.impl;

import com.pm.pacient_service.dto.request.PatientRequestDto;
import com.pm.pacient_service.dto.response.PatientResponseDto;
import com.pm.pacient_service.exception.custom.EmailAlreadyExistsException;
import com.pm.pacient_service.mapper.PatientMapper;
import com.pm.pacient_service.model.Patient;
import com.pm.pacient_service.repository.PatientRepository;
import com.pm.pacient_service.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl  implements PatientService {

    private final PatientRepository patientRepository;


    @Override
    public List<PatientResponseDto> getPatients() {
        return patientRepository
                .findAll()
                .stream()
                .map(PatientMapper::toDto)
                .toList();
    }

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patient) {
        if(patientRepository.existsByEmail(patient.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email " + patient.getEmail() + " already exists.");
        }
        Patient patientToSave = PatientMapper.toEntity(patient);
        return PatientMapper.toDto(patientRepository.save(patientToSave));
    }

}
