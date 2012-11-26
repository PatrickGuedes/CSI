package br.com.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rplayercases")
public class PlayerCase {

	@Id
	@Column(name = "player")
	private Integer playerId;
	
	@Column(name = "case")
	private Integer caseId;
	
	@Column(name = "solved")
	private Boolean solved;

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setSolved(Boolean solved) {
		this.solved = solved;
	}

	public Boolean getSolved() {
		return solved;
	}
}
