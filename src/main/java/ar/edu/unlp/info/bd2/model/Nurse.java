package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity(name="nurses")
public class Nurse extends Employee {
	
	private int experience;

	public Nurse(String fullname, String dni , int experience) {
		super(fullname, dni);
		this.experience= experience;
	}
	
	public Nurse() {
	}
	
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
}
