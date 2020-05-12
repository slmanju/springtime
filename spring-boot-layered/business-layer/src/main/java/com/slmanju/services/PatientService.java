package com.slmanju.services;

import com.slmanju.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

  Optional<Patient> findById(Integer id);

  List<Patient> findAll();

  void save(Patient patient);

}
