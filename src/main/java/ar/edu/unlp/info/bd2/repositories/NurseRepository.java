package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Staff;

public interface NurseRepository extends CrudRepository<Nurse,Long> {

	Nurse findByDni(String dni);
	
	@Query("from nurses where experience> :years")
	List<Nurse> getNurseWithMoreThanNYearsExperience(@Param("years") int years);

	@Query("select n from nurses as n WHERE n.id NOT IN"
	   		+ "(SELECT nur.id FROM shots as s join s.nurse as nur)")
	List<Nurse> getNurseNotShot();

	@Query("select n from nurses as n where n.fullname LIKE :name")
	List<Staff> getStaffWithName(@Param("name") String name);
}
