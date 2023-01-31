package com.hospital.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.dto.PatientDTO;
import com.hospital.exception.PatientAdmissionException;
import com.hospital.service.PatientService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping(value = "/api")
@Validated
public class PatientAPI {
	@Autowired
	PatientService patientService;

	@GetMapping(value = "/patients/{diagnosis}")
	public ResponseEntity<List<PatientDTO>> getPatientByDiagnosis(
			@PathVariable @Pattern(regexp = "([A-Za-z0-9\\s])", message = "{patient.diagnosis.invalid}") String diagnosis)
			throws PatientAdmissionException {
		List<PatientDTO> paList = patientService.getListOfPartients(diagnosis);
		return new ResponseEntity<>(paList, HttpStatus.OK);
	}

	@PutMapping(value = "/patients")
	public ResponseEntity<PatientDTO> admitPatient(@Valid @RequestBody PatientDTO patientDTO)
			throws PatientAdmissionException {
		PatientDTO patientDTO2 = patientService.admitPatient(patientDTO);
		return new ResponseEntity<PatientDTO>(patientDTO2, HttpStatus.CREATED);
	}
}
