package br.com.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.projeto.entity.Location;

@Entity
@Table(name = "cases")
public class Case {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "description")
	private String description;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="case")
	public Set<Location> getLocations() {
		return locations;
	}

}
