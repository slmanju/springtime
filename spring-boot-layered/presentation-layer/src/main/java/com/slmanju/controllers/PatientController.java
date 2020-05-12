package com.slmanju.controllers;

import com.slmanju.exceptions.ResourceNotFoundException;
import com.slmanju.mappers.PatientMapper;
import com.slmanju.services.PatientService;
import com.slmanju.views.PatientView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

  private final PatientService patientService;
  private final PatientMapper patientMapper;

  public PatientController(PatientService patientService, PatientMapper patientMapper) {
    this.patientService = patientService;
    this.patientMapper = patientMapper;
  }

  @GetMapping("")
  public List<PatientView> findAll() {
    return patientMapper.toViews(patientService.findAll());
  }

  @GetMapping("/{id}")
  public PatientView findById(@PathVariable("id") Integer id) {
    return patientMapper.toView(patientService.findById(id).orElseThrow(() -> new ResourceNotFoundException("No patient found")));
  }

  @PostMapping("")
  public void save(@RequestBody PatientView patientView) {
    patientService.save(patientMapper.fromView(patientView));
  }

}
