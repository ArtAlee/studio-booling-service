package com.artalee.studio.database



import java.time.LocalDateTime

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studio_records")
class StudioRecord(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long? = null,
    private var name: String,
    private var client: String,
    private var date: LocalDateTime,
    private var startTime: LocalDateTime,
    private var endTime: LocalDateTime
)