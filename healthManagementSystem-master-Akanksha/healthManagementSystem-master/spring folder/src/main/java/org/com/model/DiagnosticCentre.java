package org.com.model;

import java.util.ArrayList;

import java.util.List;


import javax.jws.Oneway;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DiagnosticCentre {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	String centreName;
	int centreId;
	List listOfTests=new ArrayList();
	List appointmentList =new ArrayList();
	
	public String getCentreName() {
		return centreName;
	}
	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}
	public int getCentreId() {
		return centreId;
	}
	public void setCentreId(int centreId) {
		this.centreId = centreId;
	}
	public List getListOfTests() {
		return listOfTests;
	}
	public void setListOfTests(List listOfTests) {
		this.listOfTests = listOfTests;
	}
	public List getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List appointmentList) {
		this.appointmentList = appointmentList;
	}
	@Override
	public String toString() {
	return "Test Centre [centreId=" + centreId + ", centreName=" + centreName + ",  listOfTests=" + listOfTests + ", appointmentList=" + appointmentList + "]";
	}
	
	
	
	

}
