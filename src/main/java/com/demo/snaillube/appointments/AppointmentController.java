package com.demo.snaillube.appointments;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/appointments")
public class AppointmentController {
    
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAllAppoinments() {
        return appointmentService.getAppoinments();
    }

    @GetMapping("today")
    public List<Appointment> getTodaysAppoinments() {
        return appointmentService.getTodaysAppoinments();
    }

    @GetMapping("{appointmentId}")
    public Optional<Appointment> getAppoinmentById(@PathVariable("appointmentId") Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAppointment(@RequestBody Appointment appointment) {
        appointmentService.createAppointment(appointment);
    }

    @DeleteMapping(path = "{appointmentId}")
    public void cancelAppointment(@PathVariable("appointmentId") Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
    }

    @PutMapping(path ="{appointmentId}")
    public void updateAppointment(
            @PathVariable("appointmentId") Long appointmentId,
            @RequestParam(required = false) LocalDateTime startDateTime,
            @RequestParam(required = false) LocalDateTime completionDateTime
    ) {
        //appointmentService.updateAppointment(appointmentId, startDateTime, completionDateTime);

    }

}