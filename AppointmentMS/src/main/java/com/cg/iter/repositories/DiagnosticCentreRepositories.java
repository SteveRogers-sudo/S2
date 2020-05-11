package com.cg.iter.repositories;

import com.cg.iter.entities.DiagnosticCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticCentreRepositories extends JpaRepository<DiagnosticCentre, Integer> {
	
}
