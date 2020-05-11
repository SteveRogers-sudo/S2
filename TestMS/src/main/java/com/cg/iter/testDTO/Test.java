/**
 * 
 */
package com.cg.iter.testDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Bishal
 *
 */
@Entity
@Table(name = "Test2")
public class Test {
	
	@Id
	private String testId;
	private String testName;
//	private String testDetails;
	
	public Test(String testId, String testName, String testDetails) {
		super();
		this.testId = testId;
		this.testName = testName;
//		this.testDetails = testDetails;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}


	
	
	
}
