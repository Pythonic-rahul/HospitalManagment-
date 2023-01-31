package com.hospital.validator;

import java.time.LocalDate;

import com.hospital.dto.PatientDTO;
import com.hospital.exception.PatientAdmissionException;

public class PatientValidator {

	public static void validatePatient(PatientDTO patientDTO) throws PatientAdmissionException{
		if(!isValidDateOfBirth(patientDTO.getDateOfBirth())) {
			throw new PatientAdmissionException("PatientValidator.INVALID_DB");
		}
		
	}
	
	public static Boolean isValidDateOfBirth(LocalDate dateOfBirth) {
		if(dateOfBirth.isAfter(LocalDate.now())||dateOfBirth.isBefore(LocalDate.now().minusYears(1000))) {
			return true;
		}
		
		
		return false;
		
	}
}
