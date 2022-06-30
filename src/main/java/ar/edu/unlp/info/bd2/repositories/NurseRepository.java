package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Nurse;

public interface NurseRepository extends CrudRepository<Nurse,Long> {

	Nurse findByDni(String dni);
	
	@Query("from nurses where experience> :years")
	List<Nurse> getNurseWithMoreThanNYearsExperience(@Param("years") int years);
}
