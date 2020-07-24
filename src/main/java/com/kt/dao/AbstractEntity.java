package com.kt.dao;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;

import jdk.jfr.Timestamp;
import lombok.Data;

@Data
public abstract class AbstractEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	protected Long id;
	
	@Version
	protected int version;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)//, pattern = DateProcessor.DATE_FORMAT)
	@Timestamp
	@Column(name = "created_at", nullable = false)
	protected LocalDateTime createdAt;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Timestamp
	@Column(name = "modified_at", nullable = false)
	protected LocalDateTime modifiedAt;
	
	public AbstractEntity() {
		this.createdAt = LocalDateTime.now();
		this.modifiedAt = LocalDateTime.now();
	}
}
