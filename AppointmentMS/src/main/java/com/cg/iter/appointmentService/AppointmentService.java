package com.cg.iter.appointmentService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.cg.iter.entities.Appointment;


public interface AppointmentService {
	
	ResponseEntity<Appointment> saveAppointment(Appointment appointment);
	
	ResponseEntity<Appointment> updateAppointment(Appointment appointment);
	
	String removeAppointment(int appointmentId);
	
	ResponseEntity<?> findAppointment(int appointmentid);
	
	List<Appointment> getAllAppointment();

}
