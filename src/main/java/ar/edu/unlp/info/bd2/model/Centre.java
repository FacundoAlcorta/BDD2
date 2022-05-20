package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;


@Entity(name="centres")
public class Centre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(
	name="centre_staff",
	joinColumns = @JoinColumn(name="centre_id"),
	inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	private Collection<Staff> staffs;
	
	public Centre() {
	}
	
	public Centre(String name) {
		staffs = new ArrayList<Staff>();
		this.name=name;
	}
	
	public void addStaff(Staff employee) {
		staffs.add(employee);
		employee.addCentres(this);
	}
	
	public String getName() {
		return name;
		}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Staff> getStaffs() {
		return this.staffs;
	}
	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public Long getId() {
		return this.id;
	}
	

}
