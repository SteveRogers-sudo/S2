package org.com.controller;

import java.util.HashMap;
import java.util.Optional;

import org.com.dao.DiagnosticCentreRepositories;
import org.com.error.RecordNotFoundException;
import org.com.model.DiagnosticCentre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

public class DiagnosticCentreController{
	
	@Autowired
	DiagnosticCentreRepositories dao;


	@PostMapping("/addCentre")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<DiagnosticCentre> addCentre(@RequestBody DiagnosticCentre dc) {
		Optional<DiagnosticCentre> findById=dao.findById(dc.getCentreId());
		try{
			if(!findById.isPresent()) {
				dao.save(dc);
				return new ResponseEntity<DiagnosticCentre>(dc, HttpStatus.OK);
				}
			else
				throw new RecordNotFoundException("Record already present...");
			}
		catch(RecordNotFoundException e){
			return new ResponseEntity<DiagnosticCentre>(dc, HttpStatus.NOT_FOUND);
			}
		}
	
	@DeleteMapping("/deleteCentre/{id}")
	public String removeCentre(@PathVariable("id") int dcid) {
		Optional<DiagnosticCentre> findById=dao.findById(dcid);
		if(findById.isPresent()) {
			dao.deleteById(dcid);
			return "centre removed";
			}
		return "centre not present";
		}
	
	
	

		
	}

