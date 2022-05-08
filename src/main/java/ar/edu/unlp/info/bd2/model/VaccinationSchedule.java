package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity(name= "vaccinationschedules")
public class VaccinationSchedule {
	
	
	@ManyToMany
	@JoinTable(
	name="schedule_vaccine",
	joinColumns = @JoinColumn(name="schedule_id"),
	inverseJoinColumns = @JoinColumn(name = "vaccine_id")
	)
	private List<Vaccine> vaccines;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	public VaccinationSchedule() {
		vaccines = new ArrayList<Vaccine>();
	}
	
	public void addVaccine(Vaccine vaccine) {
		vaccines.add(vaccine);
	}
	
	public List<Vaccine> getVaccines() {
		return vaccines;
	}
	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
