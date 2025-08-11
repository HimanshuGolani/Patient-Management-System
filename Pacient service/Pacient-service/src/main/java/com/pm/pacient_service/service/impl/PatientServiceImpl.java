package com.pm.pacient_service.service.impl;

import com.pm.pacient_service.dto.request.PatientRequestDto;
import com.pm.pacient_service.dto.response.PatientResponseDto;
import com.pm.pacient_service.dto.response.UpdatePatientResponseDto;
import com.pm.pacient_service.exception.custom.EmailAlreadyExistsException;
import com.pm.pacient_service.exception.custom.PatientNotFoundException;
import com.pm.pacient_service.mapper.PatientMapper;
import com.pm.pacient_service.model.Patient;
import com.pm.pacient_service.repository.PatientRepository;
import com.pm.pacient_service.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl  implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    @Override
    public List<PatientResponseDto> getPatients() {
        return patientRepository
                .findAll()
                .stream()
                .map(patientMapper::toDto)
                .toList();
    }

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patient) {
        if(patientRepository.existsByEmail(patient.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email " + patient.getEmail() + " already exists.");
        }
        Patient patientToSave = patientMapper.toEntity(patient);
        return patientMapper.toDto(patientRepository.save(patientToSave));
    }

    @Override
    public PatientResponseDto updatePatient(UUID id,PatientRequestDto data) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with id: "+ id)
        );
        patientMapper.updatePatientFromDto(data, patient);
        Patient updatedPatient = patientRepository.save(patient);
        return patientMapper.toDto(updatedPatient);
    }

}
