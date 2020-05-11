package org.com.service;

import java.util.List;

import org.com.model.Test;
import org.springframework.http.ResponseEntity;

public interface TestService {
	
	List<Test> getAllTest();
	/*
	 * 
	 */
	ResponseEntity<Test> addTest(Test test);
	/*
	 * 
	 */
	String removeTest(int testid);
	/*
	 * 
	 */
	ResponseEntity<Test> updateTest(Test test);
	/*
	 * 
	 */
	ResponseEntity<Test> findTest(int testid);
}
