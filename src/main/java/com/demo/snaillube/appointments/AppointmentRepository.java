package com.demo.snaillube.appointments;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    

    Appointment findByEmail(String email);

    boolean existsAppointmentByTimeslot(Integer timeslot);

    boolean existsAppointmentsByAppointmentDateAndTimeslot(LocalDate appointmentDate, Integer timeslot);
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);

}

