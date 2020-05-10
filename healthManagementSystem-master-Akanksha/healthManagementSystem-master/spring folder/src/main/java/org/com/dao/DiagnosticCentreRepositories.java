package org.com.dao;

import org.com.model.DiagnosticCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticCentreRepositories extends JpaRepository<DiagnosticCentre, Integer> {
	@Query(name="allCentres", value="select * from DiagnosticCentre d")
	public float getAllCentres();
	}
