package com.demo.snaillube.appointments;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAppoinments() {
        return appointmentRepository.findAll();
    }


    public List<Appointment> getTodaysAppoinments() {
        return appointmentRepository.findByAppointmentDate(LocalDate.now());
    }

    public Optional<Appointment> getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    public Appointment getAppointmentByEmail(String email) {
        return appointmentRepository.findByEmail(email);
    }

    public void createAppointment(Appointment appointment) {
        if (appointment.getName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer name is required.");
        }

        if (appointment.getAppointmenDate() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Appointment Date is required.");
        }

        if (appointment.getAppointmenDate().isBefore(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create appointment that is older than current date.");
        }

        if (appointment.getTimeslot() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Timeslot is required.");
        }

        int timeSlot = appointment.getTimeslot().intValue();
        if (timeSlot < 1 || timeSlot > 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Timeslot must be between 1 and 8");
        }

        boolean exists = appointmentRepository.existsAppointmentsByAppointmentDateAndTimeslot(appointment.getAppointmenDate(), appointment.getTimeslot());
        if (exists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Timeslot " + appointment.getTimeslot() + " is already taken.");
        } else {
            appointmentRepository.save(appointment);
        }
    }

    public void cancelAppointment(Long appointmentId) {
        boolean exists = appointmentRepository.existsById(appointmentId);

        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment " + appointmentId + " is not found.");
        } else {
            appointmentRepository.deleteById(appointmentId);
        }
    }

}
