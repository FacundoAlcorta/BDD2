package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import javax.persistence.*;


@Entity(name= "shots")
public class Shot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	@ManyToOne(fetch= FetchType.LAZY, optional=false)
	@JoinColumn(name="vaccine_id")
	private Vaccine vaccine;
	
	@ManyToOne(fetch= FetchType.LAZY,optional=false)
	@JoinColumn(name="centre_id")
	private Centre centre;
	
	
	private Date dayOfShot;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="nurse_id")
	private Nurse nurse;
	
	@OneToOne(mappedBy = "shot", cascade = CascadeType.ALL)
	private ShotCertificate shotCertificate;
	
	public Shot(Patient patient, Vaccine vaccine,  Date dayOfShot, Centre centre, Nurse nurse) {
		this.id= 100;
		this.patient = patient;
		this.vaccine = vaccine;
		this.centre = centre;
		this.dayOfShot = dayOfShot;
		this.nurse = nurse;
		this.shotCertificate = new ShotCertificate(); 
	}
	
	public Shot() {
		
	}
	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Vaccine getVaccine() {
		return vaccine;
	}


	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}


	public Centre getCentre() {
		return centre;
	}


	public void setCentre(Centre centre) {
		this.centre = centre;
	}


	public Date getDayOfShot() {
		return dayOfShot;
	}


	public void setDayOfShot(Date dayOfShot) {
		this.dayOfShot = dayOfShot;
	}


	public Nurse getNurse() {
		return nurse;
	}


	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}


	public Long getId() {
		return id;
	} 
	
	public void setId(long id) {
		this.id = id;
	}
	public ShotCertificate getShotCertificate() {
		
		return this.shotCertificate;
	}
	
	

	
}
