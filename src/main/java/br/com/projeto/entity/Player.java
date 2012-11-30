package br.com.projeto.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "caseOpen")
	private Integer caseOpen;
	
	@Column(name = "xp")
	private Integer xp;
	
	@Column(name = "energy")
	private Integer energy;
	
	@Column(name = "labProcessStart")
	private Date labProcessStart;
	
	@Column(name = "labProcessEnd")
	private Date labProcessEnd;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setCaseOpen(Integer caseOpen) {
		this.caseOpen = caseOpen;
	}

	public Integer getCaseOpen() {
		return caseOpen;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}

	public Integer getXp() {
		return xp;
	}

	public void setLabProcessStart(Date labProcessStart) {
		this.labProcessStart = labProcessStart;
	}

	public Date getLabProcessStart() {
		return labProcessStart;
	}

	public void setLabProcessEnd(Date labProcessEnd) {
		this.labProcessEnd = labProcessEnd;
	}

	public Date getLabProcessEnd() {
		return labProcessEnd;
	}

	public void setEnergy(Integer energy) {
		if (energy < 0) energy = 0;
		else if (energy > 100) energy = 100;
		
		this.energy = energy;
	}

	public Integer getEnergy() {
		return energy;
	}



}
