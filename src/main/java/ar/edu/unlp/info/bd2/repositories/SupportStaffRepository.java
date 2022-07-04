package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Staff;
import ar.edu.unlp.info.bd2.model.SupportStaff;

public interface SupportStaffRepository extends CrudRepository<SupportStaff,Long> {

	SupportStaff findByDni(String dni);
	
	@Query("select s.area from supportstaffs as s" + " GROUP BY area ORDER BY count(*) ASC")
	List<String> getLessEmployeesSupportStaffArea(Pageable of);

	@Query("select ss from supportstaffs as ss where ss.fullname LIKE :name")
	List<Staff> getStaffWithName(@Param("name") String name);
	
}
