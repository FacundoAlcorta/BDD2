package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import javax.persistence.*;

@Entity(name= "certificates")
public class ShotCertificate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int serialNumber;
	
	@OneToOne
	@JoinColumn(name="shot_id",referencedColumnName="id")
	private Shot shot;
	
	private Date dayOfEmision;

	
	public ShotCertificate() {
	}
	
	public ShotCertificate(Date dayOfEmision) {
		this.dayOfEmision=dayOfEmision;
		this.serialNumber= (int)((Math.random() * (Integer.MAX_VALUE - 1)) +1);
	}
	
	public Date getDayOfEmision() {
		return dayOfEmision;
	}
	public void setDayOfEmision(Date dayOfEmision) {
		this.dayOfEmision = dayOfEmision;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

}
