package com.cg.iter.repositories;

import com.cg.iter.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepositories extends JpaRepository<Appointment, Integer>{

}
