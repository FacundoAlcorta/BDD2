package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;


@Entity(name= "vaccines")
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	//@Column(name="name" ,nullable=false )
	private String name;

	public Vaccine(String name) {
		this.setName(name);
	}
	
	public Vaccine() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
