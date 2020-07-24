package com.kt.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.kt.dao.Person;


public interface PersonRepo extends AbstractEntityRepo<Person> {
	
	Optional<Person> findByUsername(String username);
	
	Set<Person> findAll();
	
	long count();
	
	int updatePassword(Long personId, String newPasswd);
	
	default List<Person> findAllUsernames(){return List.of();}

}
