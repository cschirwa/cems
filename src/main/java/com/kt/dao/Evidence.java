package com.kt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import jdk.jfr.BooleanFlag;
import lombok.Data;
@Data
@Entity
@Table(name = "evidence")
public class Evidence extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "case_fk", nullable = false)
	private CriminalCase criminalCase;
	
	@ManyToOne
	@JoinColumn(name = "storage_fk", nullable = false)
	private Storage storage;
	
	@NotEmpty
	@Column(name = "evidence_number", nullable = false)
	private String number;
	
	@NotEmpty
	private String itemName;
	
	private String notes;
	
	@BooleanFlag
	private boolean archived = false;
	
	@OneToMany(mappedBy = "evidence", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<TrackEntry> trackEntries = new HashSet<>();

}
