package com.cg.iter.appointmentService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.iter.entities.Appointment;
import com.cg.iter.appointmentService.RecordNotFoundException;
import com.cg.iter.repositories.AppointmentRepositories;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	AppointmentRepositories repo;
	
	@Override
	public List<Appointment> getAllAppointment(){
		return repo.findAll();
	}
	
	@Override
	public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
		Optional<Appointment> findById=repo.findById(appointment.getAppointmentId());
		try{
			if(!findById.isPresent()) {
				repo.save(appointment);
				return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Record already present...");
		}
		catch(RecordNotFoundException e){
			return new ResponseEntity<Appointment>(appointment, HttpStatus.NOT_FOUND);
		}
	}

	@Override
    public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment appoint) {

        Optional<Appointment> findById = repo.findById(appoint.getAppointmentId());
        try {
            if (findById.isPresent()) {
                repo.save(appoint);
                return new ResponseEntity<Appointment>(appoint, HttpStatus.OK);
            	} 
            else {
                throw new RecordNotFoundException("Appointment not present");
            }
        }
        catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

	@Override
	public String removeAppointment(@PathVariable("id") int appointmentId) {
		Optional<Appointment> findById=repo.findById(appointmentId);
		if(findById.isPresent()) {
			repo.deleteById(appointmentId);
			return "Appointment removed";
		}
		
		return "Appointment not present";
	}

	@Override
	public ResponseEntity<?> findAppointment(@PathVariable("id") int appointmentId) {
		Optional<Appointment> findById=repo.findById(appointmentId);
		try {
			if(findById.isPresent()) {
				Appointment appointment=findById.get();
				return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Record not found");
		}
		catch(RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
