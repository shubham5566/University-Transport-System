package com.transport.university.universitytransportsystem.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stoppage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stoppageId;

    @NotBlank(message = "Stoppage Name is required.")
    private String stoppageName;

    @NotNull(message = "Latitude is required")
    private Double latitude;

    @NotNull(message = "Latitude is required")
    private Double longitude;
}
