package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;

@Service
public class VaxServiceImpl implements VaxService {
	
	@Autowired
	private VaxRepository repository;
	
	public VaxServiceImpl(VaxRepository v) {
		this.repository=v;
	}
	
	@Override
	public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
		if(this.repository.findPatientByEmail(email)!=null) {
			throw new VaxException("Constraint Violation");
		}
		Patient p=new Patient(email,fullname,password,dayOfBirth);
		return (Patient) this.repository.save(p);
	}

	@Override
	public Vaccine createVaccine(String name) throws VaxException {
		if(this.repository.findVaccineByName(name)!=null) {
			throw new VaxException("Constraint Violation");
		}
		Vaccine v=new Vaccine(name);
		return (Vaccine) this.repository.save(v);
	}

	@Override
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
		Shot s=new Shot(patient,vaccine,date,centre,nurse);			
		patient.addShot(s);
		return (Shot) this.repository.save(s);
	}

	@Override
	public Optional<Patient> getPatientByEmail(String email) {
		return Optional.of(this.repository.findPatientByEmail(email));
	}

	@Override
	public Optional<Vaccine> getVaccineByName(String name) {
		return Optional.of(this.repository.findVaccineByName(name));
	}

	@Override
	public Centre createCentre(String name) throws VaxException {
		Centre c=new Centre(name);
		return (Centre) this.repository.save(c);
	}

	@Override
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
		if(this.repository.findSupportStaffByDni(dni)!=null && this.repository.findNurseByDni(dni)!=null) {
			throw new VaxException("Constraint Violation");
		}
		Nurse n=new Nurse(fullName,dni,experience);
		return (Nurse) this.repository.save(n);
	}

	@Override
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
		if(this.repository.findSupportStaffByDni(dni)!=null && this.repository.findNurseByDni(dni)!=null) {
			throw new VaxException("Constraint Violation");
		}
		SupportStaff s=new SupportStaff(fullName,dni,area);
		return (SupportStaff) this.repository.save(s);
	}

	@Override
	public VaccinationSchedule createVaccinationSchedule() throws VaxException {
		VaccinationSchedule vs=new VaccinationSchedule();
		return (VaccinationSchedule) this.repository.save(vs);
	}

	@Override
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
		return this.repository.findVaccinationScheduleById(id);
	}

	@Override
	public Optional<Centre> getCentreByName(String name) throws VaxException {
		return Optional.of(this.repository.findCentreByName(name));
	}

	@Override
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
		return (SupportStaff) this.repository.update(staff);
	}

	@Override
	public Centre updateCentre(Centre centre) {
		return (Centre) this.repository.update(centre);
	}

	@Override
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {
		return Optional.of(this.repository.findSupportStaffByDni(dni));
	}

}
