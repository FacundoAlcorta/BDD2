package ar.edu.unlp.info.bd2.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity(name= "certificates")
public class ShotCertificate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long serialNumber;
	
	@OneToOne
	@JoinColumn(name="shot_id",referencedColumnName="id")
	private Shot shot;
	
	private LocalDateTime dayOfEmision;

	
	public ShotCertificate() {
	}
	
	public LocalDateTime getDayOfEmision() {
		return dayOfEmision;
	}
	public void setDayOfEmision(LocalDateTime dayOfEmision) {
		this.dayOfEmision = dayOfEmision;
	}

	public Long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}

}
