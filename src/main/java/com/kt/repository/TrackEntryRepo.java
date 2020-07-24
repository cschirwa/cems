package com.kt.repository;

import java.util.Date;
import java.util.Set;

import com.kt.dao.TrackEntry;
import com.kt.util.TrackAction;

public interface TrackEntryRepo extends AbstractEntityRepo<TrackEntry>{
	
	Set<TrackEntry> findByDetectiveId(Long detectiveId);
    Set<TrackEntry> findByEvidenceId(Long evidenceId);
    Set<TrackEntry> findByDate(Date date);
    Set<TrackEntry> findByDateAndAction(Date date, TrackAction action);

}
