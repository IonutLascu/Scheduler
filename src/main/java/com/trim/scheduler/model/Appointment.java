package com.trim.scheduler.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name = "appointments")
@Data
public class Appointment {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    @Column(name = "from", nullable = false)
    private Instant from;

    @Column(name = "to", nullable = false)
    private Instant to;

    @Column(name = "name", nullable = false)
    private String name;
}
