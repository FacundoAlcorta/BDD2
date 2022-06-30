package ar.edu.unlp.info.bd2.repositories;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Centre;

public interface CentreRepository extends CrudRepository<Centre,Long> {
	
	Centre findByName(String name);

}
