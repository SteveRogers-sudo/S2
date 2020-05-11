package com.cg.iter.diagnosticCentre.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.cg.iter.diagnosticCentre.repository.*;
import com.cg.iter.diagnosticCentre.service.*;
import com.cg.iter.diagnosticCentre.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosticCentre")

public class DiagnosticCentreController {
	
	@Autowired
	DiagnosticCentreService dcservice;
	
	@RequestMapping("/allDiagnosticCentres")
	public List<DiagnosticCentre> getAllDiagnosticCentres(){
		return dcservice.getAllDiagnosticCentres();
	}
	
	@PostMapping("/addDiagnosticCentre")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<DiagnosticCentre> saveDiagnosticCentre(@RequestBody DiagnosticCentre center) {
		return dcservice.saveDiagnosticCentre(center);
	}
	
	@DeleteMapping("/deleteDiagnosticCentre/{id}")
	public String removeDiagnosticCentre(@PathVariable("id") String centerId) {
		return dcservice.removeDiagnosticCentre(centerId);
	}
	
	@PutMapping("/updateDiagnosticCentre")
    public ResponseEntity<DiagnosticCentre> updateDiagnosticCentre(@Valid @RequestBody DiagnosticCentre center) {
			return dcservice.updateDiagnosticCentre(center);
        }
    }

