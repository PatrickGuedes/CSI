package br.com.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rplayertraces")
public class PlayerTrace {
	
	@Id
	@GeneratedValue
	long id;
	
	@Column(name = "playerId")
	private Integer playerId;
	
	@Column(name = "traceId")
	private Integer traceId;
	
	@Column(name = "processed")
	private Boolean processed;

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setTraceId(Integer traceId) {
		this.traceId = traceId;
	}

	public Integer getTraceId() {
		return traceId;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	public Boolean getProcessed() {
		return processed;
	}

}
