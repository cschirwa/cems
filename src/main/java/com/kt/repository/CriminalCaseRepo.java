package com.kt.repository;

import java.util.Optional;
import java.util.Set;

import com.kt.dao.CriminalCase;
import com.kt.dao.Detective;
import com.kt.util.CaseStatus;
import com.kt.util.CaseType;

public interface CriminalCaseRepo extends AbstractEntityRepo<CriminalCase>{

//	void save(CriminalCase criminalCase);
	
//	void delete(String caseNumber);
	
//	CriminalCase update(CriminalCase criminalCase);
	
	Set<CriminalCase> findByLeadInvestigator(Detective detective);
	
	Optional<CriminalCase> findByNumber(String caseNumber);
	
	Set<CriminalCase> findByType(CaseType type);
	
	Set<CriminalCase> findByStatus(CaseStatus caseStatus);
	
	
	
}
