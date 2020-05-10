package org.com.dao;

import java.util.List;

import org.com.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepositories extends JpaRepository<Test, String> {
	@Query(name="avgCost", value="select avg(t.testCost) from Test t")
	public float getAvgCost();


}
