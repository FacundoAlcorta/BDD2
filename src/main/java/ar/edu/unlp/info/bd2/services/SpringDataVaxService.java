package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import ar.edu.unlp.info.bd2.model.Staff;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.repositories.VaxException;

public class SpringDataVaxService implements VaxService {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine createVaccine(String name) throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse)
			throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Patient> getPatientByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Vaccine> getVaccineByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Centre createCentre(String name) throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccinationSchedule createVaccinationSchedule() throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Centre> getCentreByName(String name) throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Centre updateCentre(Centre centre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

}
