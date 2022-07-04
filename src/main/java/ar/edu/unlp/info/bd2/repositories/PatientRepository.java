package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Patient;

public interface PatientRepository extends CrudRepository<Patient,Long> {
	
	Patient findByEmail(String email);
}
