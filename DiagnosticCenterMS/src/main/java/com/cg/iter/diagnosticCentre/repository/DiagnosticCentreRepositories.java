package com.cg.iter.diagnosticCentre.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.diagnosticCentre.entities.DiagnosticCentre;

@Repository
public interface DiagnosticCentreRepositories extends JpaRepository<DiagnosticCentre, Integer> {

	void deleteById(String centerId);

	Optional<DiagnosticCentre> findById(String centerId);
	
}
