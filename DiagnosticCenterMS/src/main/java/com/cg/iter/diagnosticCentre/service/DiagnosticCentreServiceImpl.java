package com.cg.iter.diagnosticCentre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.iter.diagnosticCentre.entities.DiagnosticCentre;
import com.cg.iter.diagnosticCentre.repository.DiagnosticCentreRepositories;

@Service
public class DiagnosticCentreServiceImpl implements DiagnosticCentreService {

	DiagnosticCentreRepositories dao;
	@Override
	public ResponseEntity<DiagnosticCentre> saveDiagnosticCentre(DiagnosticCentre center) {
		Optional<DiagnosticCentre> findById=dao.findById(center.getDiagnosticCentreId());
		try{
			if(!findById.isPresent()) {
				dao.save(center);
				return new ResponseEntity<DiagnosticCentre>(center, HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Diagnostic Centre already present...");
		}
		catch(RecordNotFoundException e){
			return new ResponseEntity<DiagnosticCentre>(center, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public String removeDiagnosticCentre(String centerId) {
		Optional<DiagnosticCentre> findById=dao.findById(centerId);
		if(findById.isPresent()) {
			dao.deleteById(centerId);
			return "Diagnostic Centre removed";
		}
		return "Diagnostic Centre not present";
	}

	@Override
	public ResponseEntity<DiagnosticCentre> updateDiagnosticCentre(DiagnosticCentre center) {
		Optional<DiagnosticCentre> findById = dao.findById(center.getDiagnosticCentreId());
        try {
            if (findById.isPresent()) {
                dao.save(center);
                return new ResponseEntity<DiagnosticCentre>(center, HttpStatus.OK);
            	} 
            else {
                throw new RecordNotFoundException("Diagnostic Centre not present");
            }
        }
        catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
	}

	@Override
	public List<DiagnosticCentre> getAllDiagnosticCentres() {
		return dao.findAll();
	}

}

