package com.cg.iter.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DiagnosticCentre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int diagnosticCentreId;
	private String centreName;
	private String centreAddress;
	
	@OneToMany(mappedBy = "diagnosticCentre")
	private List<Test> listOfTests;
	
//	@OneToMany(mappedBy = "diagnosticCentre")
//	private List<Appointment> appointmentList;
	
	
	public int getDiagnosticCentreId() {
		return diagnosticCentreId;
	}
	public void setDiagnosticCentreId(int diagnosticCentreId) {
		this.diagnosticCentreId = diagnosticCentreId;
	}
	public String getCentreName() {
		return centreName;
	}
	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}
	public String getCentreAddress() {
		return centreAddress;
	}
	public void setCentreAddress(String centreAddress) {
		this.centreAddress = centreAddress;
	}
	public List<Test> getListOfTests() {
		return listOfTests;
	}
	public void setListOfTests(List<Test> listOfTests) {
		this.listOfTests = listOfTests;
	}
	
	
}
