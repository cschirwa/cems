package com.kt.dao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.kt.util.TrackAction;

import jdk.jfr.Timestamp;
import lombok.Data;

@Data
@Entity
@Table(name = "track_entity")
public class TrackEntry extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Timestamp
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "evidence_fk")
	private Evidence evidence;
	
	@OneToOne
	private Detective detective;
	
	@Enumerated
	private TrackAction trackAction;
	
	@NotNull
	private String reason;
}
