package com.kt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.kt.util.CaseStatus;
import com.kt.util.CaseType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "criminal_case")
public class CriminalCase extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="case_number", unique = true, nullable = false, updatable = false)
	private String number;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "case_type")
	private CaseType type;
	
	@NotEmpty
	@Column(name = "short_description")
	private String shortDescription;
	
	private String detailedDescription;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CaseStatus status;
	private String notes;
	
	@OneToMany(mappedBy = "criminalCase", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Evidence> evidenceSet = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "LEAD_INVESTIGATOR", nullable = false)
	private Detective leadInvestigator;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "working_detective_case", 
				joinColumns = @JoinColumn(name = "case_id", referencedColumnName = "id"),
				inverseJoinColumns= @JoinColumn(name = "detective_id", referencedColumnName = "id"))
	private Set<Detective> assigned;
	
	public CriminalCase() {
		super();
		this.type = CaseType.UNCATEGORIZED;
		this.status = CaseStatus.SUBMITTED;
	}
	
}
