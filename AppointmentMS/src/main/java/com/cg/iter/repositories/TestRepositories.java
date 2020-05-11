package com.cg.iter.repositories;

import com.cg.iter.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepositories extends JpaRepository<Test, Integer> {
	
}