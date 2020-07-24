package com.kt.dao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.kt.util.EmploymentStatus;
import com.kt.util.Rank;

import jdk.jfr.BooleanFlag;
import lombok.Data;

@Entity
@Data
@Table(name = "detective")
public class Detective extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "person_id")
	protected Person person;

	@NotEmpty
	protected String badgeNumber;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	protected Rank rank;
	
	@BooleanFlag
	protected boolean armed;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	protected EmploymentStatus status;
	
	@OneToMany(mappedBy = "detective")
	protected Set<TrackEntry> trackEntries;
	
	public Detective() {
        super();
    }
}
