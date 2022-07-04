package ar.edu.unlp.info.bd2.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.ShotCertificate;

public interface ShotCertificateRepository extends CrudRepository<ShotCertificate,Long> {

	@Query("select sc from certificates as sc where sc.dayOfEmision >= :sd AND sc.dayOfEmision <= :ed")
	List<ShotCertificate> getShotCertificatesBetweenDates(@Param("sd")Date startDate, @Param("ed")Date endDate);
	
	

}
