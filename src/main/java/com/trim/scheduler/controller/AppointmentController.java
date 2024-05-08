package com.trim.scheduler.controller;

import com.trim.scheduler.domain.AppointmentDTO;
import com.trim.scheduler.model.Appointment;
import com.trim.scheduler.repository.AppointmentRepository;
import com.trim.scheduler.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO savedAppointmentDTO = appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.ok(savedAppointmentDTO);
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
}