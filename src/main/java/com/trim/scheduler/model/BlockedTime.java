package com.trim.scheduler.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "blocked_times")
@Data
public class BlockedTime {

    @Id
    @SequenceGenerator(name = "blocked_times_sequence", sequenceName = "blocked_times_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blocked_times_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id", nullable = false)
    private Calendar calendar;

    @Column(name = "from", nullable = false)
    private Instant from;

    @Column(name = "to", nullable = false)
    private Instant to;

    @Column(name = "description")
    private String description;
}