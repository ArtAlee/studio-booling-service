package com.artalee.studio.database

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "booking")
data class StudioRecord(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "studio_name")
    val studioName: String,

    @Column(name = "client_name")
    val clientName: String,

    @Column(name = "start_time")
    val startTime: LocalDateTime,

    @Column(name = "end_time")
    val endTime: LocalDateTime
)
