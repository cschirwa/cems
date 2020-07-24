package com.kt.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
@Entity
@Table(name = "storage")
public class Storage extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	private String name;
	
	@NotEmpty
	private String location;
	
	@OneToMany(mappedBy = "storage", cascade = CascadeType.DETACH)
	private Set<Evidence> evidenceSet;

}
