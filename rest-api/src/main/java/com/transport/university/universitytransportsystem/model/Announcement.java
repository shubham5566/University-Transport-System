package com.transport.university.universitytransportsystem.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import jakarta.persistence.*;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;

    @NotNull(message = "Date is required")
    private Date date;

    @NotBlank(message = "Announcement can not be empty")
	@Column(columnDefinition = "TEXT")
    private String announcement;
}
