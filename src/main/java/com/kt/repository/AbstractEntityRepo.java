package com.kt.repository;

import java.util.Optional;

import com.kt.dao.AbstractEntity;

public interface AbstractEntityRepo <T extends AbstractEntity> {
	
	void save(T entity);
	
	void delete(T entity);
	
	T update(T entity);
	
	void deleteById(Long entityId);
	
	Optional<T> findById(Long entityId);

}
