package com.kt.repository;

import java.util.Optional;

import com.kt.dao.Storage;

public interface StorageRepo extends AbstractEntityRepo<Storage>{

	Optional<Storage> findByName(String name);
	
	Optional<Storage> findByLocation(String location);
}
