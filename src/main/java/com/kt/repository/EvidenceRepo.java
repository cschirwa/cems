package com.kt.repository;

import java.util.Optional;
import java.util.Set;

import com.kt.dao.CriminalCase;
import com.kt.dao.Evidence;
import com.kt.dao.Storage;

public interface EvidenceRepo extends AbstractEntityRepo<Evidence> {

	Set<Evidence> findByCriminalCase(CriminalCase criminalCase);
	
	Optional<Evidence> findByNumber(String evidenceNumber);
	
	boolean isInStorage(Storage storage);
}
