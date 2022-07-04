package ar.edu.unlp.info.bd2.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import ar.edu.unlp.info.bd2.model.Staff;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;

@Repository
@Transactional
public class VaxRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public VaxRepository() {
		
	}
	
	public Session  getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public Object save(Object obj) {
		this.getSession().save(obj);
		this.getSession().flush();
		return obj;
	}
	
	public Object update(Object obj){
		this.getSession().update(obj);
		this.getSession().flush();
		return obj;
	}
	
	public Patient findPatientByEmail(String email) {
		Query query=this.getSession().createQuery("from patients where email= :email").setParameter("email", email);
		try {
			return (Patient)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public Vaccine findVaccineByName(String name) {
		Query query=this.getSession().createQuery("from vaccines where name= :name").setParameter("name", name);
		try {
			return (Vaccine)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public Centre findCentreByName(String name){
		Query query=this.getSession().createQuery("from centres where name= :name").setParameter("name", name);
		try {
			return (Centre)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public SupportStaff findSupportStaffByDni(String dni){
		Query query=this.getSession().createQuery("from supportstaffs where dni= :dni").setParameter("dni", dni);
		try {
			return (SupportStaff)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public VaccinationSchedule findVaccinationScheduleById(Long id){
		Query query=this.getSession().createQuery("from vaccinationschedules where id= :id").setParameter("id", id);
		try {
			return (VaccinationSchedule)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public Nurse findNurseByDni(String dni){
		Query query=this.getSession().createQuery("from nurses where dni= :dni").setParameter("dni", dni);
		try {
			return (Nurse)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years){
		Query query=this.getSession().createQuery("from nurses where experience> :years").setParameter("years",years);
		return (List<Nurse>) query.getResultList();
	}
	
	public Centre getTopShotCentre() {
		Query query=this.getSession().createQuery("select c from shots as s JOIN s.centre as c"
				+ " GROUP BY c ORDER BY count(*) DESC").setMaxResults(1);
		try {
			return (Centre)query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public String getLessEmployeesSupportStaffArea() {
		Query query=this.getSession().createQuery("select s.area from supportstaffs as s"
				+ " GROUP BY area ORDER BY count(*) ASC").setMaxResults(1);
		try {
			return (String)query.getSingleResult();
		}
		catch(NoResultException e) {
			return null;
		}
	}
	
	public List<Vaccine> getUnappliedVaccines(){
		Query query=this.getSession().createQuery("select v from vaccines as v where v.id not in"
				+ "(select vac.id from shots as s join s.vaccine as vac)");
		List<Vaccine> vaccines= query.getResultList();
		return vaccines;
	}
	
	public List<Nurse> getNurseNotShot() {
		String hql = "select n from nurses as n WHERE n.id NOT IN"
		   		+ "(SELECT nur.id FROM shots as s join s.nurse as nur)";
		   Query query = getSession().createQuery(hql);
		   List<Nurse> nurses = query.getResultList();
		   return nurses;
	}

	public List<Patient> getAllPatients() {
		Query query=this.sessionFactory.getCurrentSession().createQuery("SELECT p from patients p");
		try {
			return query.getResultList();
		}
		catch(NoResultException e){
			return null;
		}
	}

	public List<Centre> getCentresTopNStaff(int n) {
		String hql = "select c from centres as c JOIN c.staffs "
				+ "GROUP BY c ORDER BY count(*) DESC";
		Query query = getSession().createQuery(hql);
		List<Centre> centres = query.setMaxResults(n).getResultList();
		return centres;
	}

	public List<Staff> getStaffWithName(String name) {
		//QUERY PARA LA TABLA DE NURSES
		String hql ="select n from nurses as n where n.fullname LIKE :name";
		Query query = getSession().createQuery(hql).setParameter("name", "%"+name+"%");
		
		//QUERY PARA LA TABLA DE SUPPORTSTAFFS
		String hql2 ="select ss from supportstaffs as ss where ss.fullname LIKE :name";
		Query query2 = getSession().createQuery(hql2).setParameter("name", "%"+name+"%");
		
		//JUNTAR LOS STAFF DE LAS DOS QUERYS EN UNA LISTA
		List<Staff> staffs = query.getResultList();
		staffs.addAll(query2.getResultList());
		return staffs;
	}

	public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
		String hql = "select sc from certificates as sc where sc.dayOfEmision >= :sd AND sc.dayOfEmision <= :ed";
		Query query = getSession().createQuery(hql).setParameter("sd",startDate).setParameter("ed", endDate);
		List<ShotCertificate> shotCertificates = query.getResultList();
		return shotCertificates;
	}
}
