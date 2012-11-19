package br.com.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "case")
	private Integer case;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}


}
