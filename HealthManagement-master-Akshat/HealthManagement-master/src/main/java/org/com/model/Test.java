package org.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HCTest")
public class Test {
	@Id
	private String testId;
	private String testName;
	private String testDetails;
	private float testCost;
	
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
	public String getTestDetails() {
		return testDetails;
	}
	public void setTestDetails(String testDetails) {
		this.testDetails = testDetails;
	}
	public float getTestCost() {
		return testCost;
	}
	public void setTestCost(float testCost) {
		this.testCost = testCost;
	}
	
	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + ", testDetails=" + testDetails + ", testCost="
				+ testCost + "]";
	}
}
