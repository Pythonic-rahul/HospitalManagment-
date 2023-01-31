package com.hospital.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public class PatientDTO {
	private Integer patientId;
	// messsage do not hardcoded
	@NotNull(message="{patient.name.notpresent}")
	@Pattern(regexp = "([A-Za-z]+)(\\s[A-Za-z]+)*", message = "{patient.name.invalid}")
	private String patientName;
	private LocalDate dateOfBirth;
	@NotNull(message = "{patient.gender.notpresent}")
	@Pattern(regexp = "Male|Female|Others", message = "{patient.gender.invalid}")
	private String gender;
	@NotNull(message = "{patient.admissiondate.notpresent}") 
	@PastOrPresent(message = "{patient.admissiondate.invalid}")
	@FutureOrPresent(message = "{patient.admissiondate.invalid}")
	private LocalDate admissionDate;
	@NotNull(message = "{patient.diagnosis.notpresen}")
	@Pattern(regexp = "([A-Za-z0-9]+)(\\s[A-Za-z0-9]+)*")
	private String diagnosis;

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

}
