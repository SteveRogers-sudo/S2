
package com.cg.iter.testService;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.iter.testDTO.Test;

/**
 * @author Bishal
 *
 */
public interface TestService {
	
		List<Test> getAllTest();
		/*
		 * 
		 */
		boolean saveTest(Test test);
		/*
		 * 
		 */
		boolean removeTest(String tid);		
		/*
		 * 
		 */
		boolean updateTest(Test test);
		/*
		 * 
		 */
		
}
