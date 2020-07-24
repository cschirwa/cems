package com.kt.dao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "person")
@JsonIgnoreProperties(value = "password", allowSetters = true)
public class Person extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, updatable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	@Size(min = 3, max = 12, message = "Lastname must be between 3 and 12 xrs")
	private String lastname;

	@JsonProperty(access = Access.WRITE_ONLY)
//	@JsonIgnore
	@Transient
	private String password;

	@Column(nullable = false)
	private LocalDateTime hiringDate;

}
