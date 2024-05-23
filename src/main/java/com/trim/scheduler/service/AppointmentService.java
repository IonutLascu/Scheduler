package com.trim.scheduler.service;

import com.trim.scheduler.domain.AppointmentDTO;
import com.trim.scheduler.mapper.AppointmentMapper;
import com.trim.scheduler.mapper.CalendarMapper;
import com.trim.scheduler.model.Appointment;
import com.trim.scheduler.repository.AppointmentRepository;
import com.trim.scheduler.utils.ApiException;
import com.trim.scheduler.utils.ErrorConstants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper mapper;
    private final CalendarService calendarService;
    private final CalendarMapper calendarMapper;

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.toEntity(appointmentDTO);
        var calendarOpt = calendarService.findByName(appointmentDTO.getCalendarName());

        if (calendarOpt.isEmpty()) {
            throw new ApiException("Invalid calendar name", ErrorConstants.NOT_FOUND, HttpStatus.BAD_REQUEST);
        }
        appointment.setCalendar(calendarMapper.toEntity(calendarOpt.get()));
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return mapper.toDto(savedAppointment);
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
            .stream()
            .map(mapper::toDto)
            .toList();
    }
}