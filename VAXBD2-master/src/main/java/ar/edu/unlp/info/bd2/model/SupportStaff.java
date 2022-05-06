package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity(name= "supportstaffs")
public class SupportStaff extends Employee{
	private String area;

	public SupportStaff(String fullname, String dni, String area) {
		super(fullname, dni);
		this.setArea(area);
	}
	
	public SupportStaff() {
		
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
