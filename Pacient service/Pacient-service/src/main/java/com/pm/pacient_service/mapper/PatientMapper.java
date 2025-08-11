package com.pm.pacient_service.mapper;

import com.pm.pacient_service.dto.request.PatientRequestDto;
import com.pm.pacient_service.dto.response.PatientResponseDto;
import com.pm.pacient_service.model.Patient;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePatientFromDto(PatientRequestDto dto, @MappingTarget Patient entity);

    @Mapping(target = "id", expression = "java(patient.getId().toString())")
    @Mapping(target = "dateOfBirth", expression = "java(patient.getDateOfBirth().toString())")
    PatientResponseDto toDto(Patient patient);

    @Mapping(target = "id", ignore = true) // assuming id is auto-generated
    @Mapping(target = "dateOfBirth", expression = "java(LocalDate.parse(patient.getDateOfBirth()))")
    Patient toEntity(PatientRequestDto patient);
}
