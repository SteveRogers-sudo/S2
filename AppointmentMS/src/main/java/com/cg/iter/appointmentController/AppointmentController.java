package com.cg.iter.appointmentController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.iter.entities.Appointment;
import com.cg.iter.appointmentService.RecordNotFoundException;
import com.cg.iter.repositories.AppointmentRepositories;
import com.cg.iter.appointmentService.AppointmentService;

@RestController
@RequestMapping("/appoint")
public class AppointmentController {
	
	RestTemplate restTemplate;
	
	@Autowired
	AppointmentService appointmentService;
	
	private String appointmentURL = "http://AppointmentMS/appoint";
	
	@RequestMapping("/allAppointments")
	public List<Appointment> getAllAppointments(){
		Appointment appointment = restTemplate.getForObject(appointmentURL+"allAppointments", Appointment.class);
		return appointmentService.getAllAppointment();
	}
	
	@RequestMapping("/searchAppointment/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> findAppointment1(@PathVariable("id") int appointmentid) {
		return appointmentService.findAppointment(appointmentid);
	}
		
	@PostMapping("/addAppointment")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Appointment> saveAppointment2(@RequestBody Appointment appointment) {
		return appointmentService.saveAppointment(appointment);
	}
	
	@DeleteMapping("/deleteAppointment/{id}")
	public String removeAppointment(@PathVariable("id") int appointmentId) {
		return appointmentService.removeAppointment(appointmentId);
	}
	
	@PutMapping("/updateAppointment")
    public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment appoint) {
		return appointmentService.updateAppointment(appoint);
    }
}
