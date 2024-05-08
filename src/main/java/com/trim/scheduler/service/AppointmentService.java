package com.trim.scheduler.service;

import com.trim.scheduler.domain.AppointmentDTO;
import com.trim.scheduler.mapper.AppointmentMapper;
import com.trim.scheduler.model.Appointment;
import com.trim.scheduler.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper mapper;

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.toEntity(appointmentDTO);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return mapper.toDto(savedAppointment);
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
            .stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }
}