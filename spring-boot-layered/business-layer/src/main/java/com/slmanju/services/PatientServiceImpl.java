package com.slmanju.services;

import com.slmanju.entities.Patient;
import com.slmanju.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

  private final PatientRepository patientRepository;

  public PatientServiceImpl(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  @Override
  public Optional<Patient> findById(Integer id) {
    return patientRepository.findById(id);
  }

  @Override
  public List<Patient> findAll() {
    return patientRepository.findAll();
  }

  @Override
  public void save(Patient patient) {
    patientRepository.save(patient);
  }

}
