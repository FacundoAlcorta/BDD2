package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Centre;


public interface CentreRepository extends CrudRepository<Centre,Long> {
	
	Centre findByName(String name);
	
	@Query("select c from shots as s JOIN s.centre as c" + " GROUP BY c ORDER BY count(*) DESC")
	List<Centre> getTopShotCentre(Pageable of);

	@Query("select c from centres as c JOIN c.staffs "
	+ "GROUP BY c ORDER BY count(*) DESC ")
	List<Centre> getCentresTopNStaff(Pageable of);

}
