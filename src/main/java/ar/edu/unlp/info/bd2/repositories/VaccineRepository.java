package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Vaccine;

public interface VaccineRepository extends CrudRepository<Vaccine,Long> {
	
	Vaccine findByName(String name);
	
	@Query("select v from vaccines as v where v.id not in" 
	+ "(select vac.id from shots as s join s.vaccine as vac)")
	List<Vaccine> getVaccineNotShot();

}
