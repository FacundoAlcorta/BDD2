package ar.edu.unlp.info.bd2.repositories;

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
	
	public Object update(Object obj) {
		this.getSession().update(obj);
		this.getSession().flush();
		return obj;
	}
	
	public Patient findPatientByEmail(String email) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from patients where email= :email").setParameter("email", email);
		try {
			return (Patient)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public Vaccine findVaccineByName(String name) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from vaccines where name= :name").setParameter("name", name);
		try {
			return (Vaccine)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public Centre findCentreByName(String name) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from centres where name= :name").setParameter("name", name);
		return (Centre) query.getSingleResult();
	}
	
	public SupportStaff findSupportStaffByDni(String dni) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from supportstaffs where dni= :dni").setParameter("dni", dni);
		try {
			return (SupportStaff)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
	public VaccinationSchedule findVaccinationScheduleById(Long id) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from vaccinationschedules where id= :id").setParameter("id", id);
		return (VaccinationSchedule) query.getSingleResult();
	}
	
	public Nurse findNurseByDni(String dni) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from nurses where dni= :dni").setParameter("dni", dni);
		try {
			return (Nurse)query.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
	}
	
}
