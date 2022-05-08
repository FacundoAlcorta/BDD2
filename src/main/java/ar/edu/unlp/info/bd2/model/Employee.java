package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	
	@ManyToMany(mappedBy = "staffs")
	protected List<Centre> centres;
	
	protected String fullname;
	protected String dni;
	
	public Employee() {
	}
	
	public Employee(String fullname , String dni) {
		this.dni = dni;
		this.fullname = fullname;
		centres = new ArrayList<Centre>();
	}
	
	public String getFullName(){
		return this.fullname;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public void addCentres(Centre centre) {
		this.centres.add(centre);
	}
	
	public List<Centre> getCentres(){
		return this.centres;
	}
	
	
	

}
