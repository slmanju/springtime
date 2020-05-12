package com.slmanju.mappers;

import com.slmanju.entities.Patient;
import com.slmanju.views.PatientView;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class PatientMapper {

  public PatientView toView(Patient patient) {
    return PatientView.builder()
        .id(patient.getId())
        .firstName(patient.getFirstName())
        .lastName(patient.getLastName())
        .build();
  }

  public Patient fromView(PatientView patientView) {
    return Patient.builder()
        .id(patientView.getId())
        .firstName(patientView.getFirstName())
        .lastName(patientView.getLastName())
        .build();
  }

  public List<PatientView> toViews(List<Patient> patients) {
    return patients.stream().map(this::toView).collect(toList());
  }

}
