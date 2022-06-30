package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import ar.edu.unlp.info.bd2.model.Staff;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.repositories.*;

@Service
public class SpringDataVaxService implements VaxService {
	
	@Autowired
	private CentreRepository centreRepository;
	
	@Autowired
	private NurseRepository nurseRepository; 
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ShotCertificateRepository shotCertificateRepository;
	
	@Autowired
	private ShotRepository shotRepository;
	
	@Autowired
	private SupportStaffRepository supportStaffRepository;
	
	@Autowired
	private VaccinationScheduleRepository vaccinationScheduleRepository;
	
	@Autowired
	private VaccineRepository vaccineRepository; 
	

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Centre> getCentresTopNStaff(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Centre getTopShotCentre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nurse> getNurseNotShot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLessEmployeesSupportStaffArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> getStaffWithName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vaccine> getUnappliedVaccines() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
		if(this.patientRepository.findByEmail(email)!=null) {
			throw new VaxException("Constraint Violation");
		}
		Patient p=new Patient(email,fullname,password,dayOfBirth);
		return this.patientRepository.save(p);
	}

	@Override
	public Vaccine createVaccine(String name) throws VaxException {
		if(this.vaccineRepository.findByName(name)!=null) {
			throw new VaxException("Constraint Violation");
		}
		Vaccine v=new Vaccine(name);
		return this.vaccineRepository.save(v);
	}

	@Override
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse)
			throws VaxException {
		Shot s=new Shot(patient,vaccine,date,centre,nurse);			
		patient.addShot(s);
		return this.shotRepository.save(s);
	}

	@Override
	public Optional<Patient> getPatientByEmail(String email) {
		return Optional.of(this.patientRepository.findByEmail(email));
	}

	@Override
	public Optional<Vaccine> getVaccineByName(String name) {
		return Optional.of(this.vaccineRepository.findByName(name));
	}

	@Override
	public Centre createCentre(String name) throws VaxException {
		Centre c=new Centre(name);
		return this.centreRepository.save(c);
	}

	@Override
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
		if(this.supportStaffRepository.findByDni(dni)!=null && this.nurseRepository.findByDni(dni)!=null) {
			throw new VaxException("Constraint Violation");
		}
		Nurse n=new Nurse(fullName,dni,experience);
		return this.nurseRepository.save(n);
	}

	@Override
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
		if(this.supportStaffRepository.findByDni(dni)!=null && this.nurseRepository.findByDni(dni)!=null) {
			throw new VaxException("Constraint Violation");
		}
		SupportStaff s=new SupportStaff(fullName,dni,area);
		return this.supportStaffRepository.save(s);
	}

	@Override
	public VaccinationSchedule createVaccinationSchedule() throws VaxException {
		VaccinationSchedule vs=new VaccinationSchedule();
		return this.vaccinationScheduleRepository.save(vs);
	}

	@Override
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
		return this.vaccinationScheduleRepository.findById(id).get();
	}

	@Override
	public Optional<Centre> getCentreByName(String name) throws VaxException {
		return Optional.of(this.centreRepository.findByName(name));
	}

	@Override
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
		return this.supportStaffRepository.save(staff);
	}

	@Override
	public Centre updateCentre(Centre centre) {
		return this.centreRepository.save(centre);
	}

	@Override
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {
		return Optional.of(this.supportStaffRepository.findByDni(dni));
	}

	@Override
	public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) {
		return this.vaccinationScheduleRepository.save(schedule);
	}

}
