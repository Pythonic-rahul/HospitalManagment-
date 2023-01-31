package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hospital.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

	List<Patient> findBydiagnosis(String diagnosis);

}
