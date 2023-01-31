package com.hospital.service;

import java.util.List;

import com.hospital.dto.PatientDTO;
import com.hospital.exception.PatientAdmissionException;

public interface PatientService  {
	public List<PatientDTO> getListOfPartients(String diagnosis) throws PatientAdmissionException;
	
 public PatientDTO admitPatient(PatientDTO patientDTO) throws PatientAdmissionException;

}
