package com.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.dto.PatientDTO;
import com.hospital.entity.Patient;
import com.hospital.exception.PatientAdmissionException;
import com.hospital.repository.PatientRepository;
import com.hospital.validator.PatientValidator;

@Service(value = "patientService")
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<PatientDTO> getListOfPartients(String diagnosis) throws PatientAdmissionException {
		// TODO Auto-generated method stub
		List<Patient> lisOfDiagnosis = patientRepository.findBydiagnosis(diagnosis);
		if (lisOfDiagnosis.isEmpty()) {
			throw new PatientAdmissionException("PatientService.PATIENT_UNAVAILBLE");

		}
		List<PatientDTO> list = new ArrayList<PatientDTO>();
		for (PatientDTO p : list) {
			PatientDTO pdto = new PatientDTO();
			pdto.setAdmissionDate(p.getAdmissionDate());
			pdto.setDateOfBirth(p.getDateOfBirth());
			pdto.setDiagnosis(p.getDiagnosis());
			pdto.setGender(p.getGender());
			pdto.setPatientId(p.getPatientId());
			pdto.setPatientName(p.getPatientName());

			list.add(pdto);
		}

		return list;
	}

	@Override
	public PatientDTO admitPatient(PatientDTO patientDTO) throws PatientAdmissionException {
		// TODO Auto-generated method stub
		PatientValidator.validatePatient(patientDTO);
		Patient pl = new Patient();
		pl.setAdmissionDate(patientDTO.getAdmissionDate());
		pl.setDateOfBirth(patientDTO.getDateOfBirth());
		pl.setDiagnosis(patientDTO.getDiagnosis());
		pl.setGender(patientDTO.getGender());
		pl.setPatientId(patientDTO.getPatientId());
		pl.setPatientName(patientDTO.getPatientName());
		patientRepository.save(pl);
		patientDTO.setPatientId(pl.getPatientId());

		return patientDTO;
	}

}
