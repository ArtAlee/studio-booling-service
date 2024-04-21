package com.artalee.studio.database

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface StudioRecordRepository : JpaRepository<StudioRecord, Long> {
    fun findByStudioName(studioName: String): List<StudioRecord>

    @Query("SELECT COUNT(s) FROM StudioRecord s WHERE s.studioName = :studioName AND NOT (s.endTime <= :startTime OR s.startTime >= :endTime)")
    fun countByTimeOverlap(studioName: String, startTime: LocalDateTime, endTime: LocalDateTime): Long
}
