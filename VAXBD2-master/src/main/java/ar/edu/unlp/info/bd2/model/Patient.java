package ar.edu.unlp.info.bd2.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

@Entity(name= "patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String email;
	private String fullname;
	private Date dayOfBirth;
	private String password;
	
	@OneToMany(fetch= FetchType.LAZY,mappedBy = "patient" , cascade=CascadeType.ALL)
	private List<Shot> shots;
	
	public Patient() {
		
	}

	public Patient(String email, String fullname, String password, Date dayOfBirth){
		setShots(new ArrayList<Shot>());
		this.email= email;
		this.fullname = fullname;
		this.password = password;
		this.dayOfBirth=dayOfBirth;
	}


	public Long getId() {
		return this.id;
	}


	public Date getDayOfBirth() {
		return this.dayOfBirth;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Shot> getShots() {
		return shots;
	}


	public void setShots(List<Shot> shots) {
		this.shots = shots;
	}

	public void addShot(Shot s) {
		shots.add(s);		
	}

}
