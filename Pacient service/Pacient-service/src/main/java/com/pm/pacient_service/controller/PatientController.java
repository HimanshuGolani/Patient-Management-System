package com.pm.pacient_service.controller;

import com.pm.pacient_service.dto.request.PatientRequestDto;
import com.pm.pacient_service.dto.response.PatientResponseDto;
import com.pm.pacient_service.dto.response.UpdatePatientResponseDto;
import com.pm.pacient_service.service.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;


    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getPatients(){
        List<PatientResponseDto> response = patientService.getPatients();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientData){
        PatientResponseDto response = patientService.createPatient(patientData);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable("userId") UUID id, @RequestBody PatientRequestDto data){
        PatientResponseDto response = patientService.updatePatient(id,data);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
