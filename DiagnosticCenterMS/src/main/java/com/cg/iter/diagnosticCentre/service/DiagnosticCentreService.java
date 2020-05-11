package com.cg.iter.diagnosticCentre.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.iter.diagnosticCentre.entities.DiagnosticCentre;

public interface DiagnosticCentreService {
	
	ResponseEntity<DiagnosticCentre> saveDiagnosticCentre(DiagnosticCentre center);

	public String removeDiagnosticCentre(String centerId);

	ResponseEntity<DiagnosticCentre> updateDiagnosticCentre(DiagnosticCentre center);
	
	List<DiagnosticCentre> getAllDiagnosticCentres();
}
