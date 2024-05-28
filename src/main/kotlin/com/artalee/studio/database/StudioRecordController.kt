package com.artalee.studio.database

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/studio")
class StudioRecordController(@Autowired private val studioRecordService: StudioRecordService) {
    private val log = LoggerFactory.getLogger(StudioRecordController::class.java)
    @PostMapping("/createRecord")
    fun createRecord(@RequestBody request: RecordRequest): ResponseEntity<Any> {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val startTime = LocalDateTime.parse(request.startTime, formatter)
        val endTime = LocalDateTime.parse(request.endTime, formatter)
        return try {
            val record = studioRecordService.createRecord(
                studioName = request.studioName,
                clientName = request.clientName,
                startTime = startTime,
                endTime = endTime
            )
            log.info("New booking has been created $record")
            ResponseEntity.ok(record)
        } catch (e: IllegalStateException) {
            log.warn("Unavailable slot cant be booked")
            ResponseEntity.status(HttpStatus.ACCEPTED).body(e.message)
        }
    }

    @Cacheable("myCache")
    @GetMapping("/getAllRecords")
    fun getAllRecords(): ResponseEntity<List<StudioRecord>> {
        log.info("Request of all bookings")
        return ResponseEntity.ok(studioRecordService.getAllRecords())
    }

    data class RecordRequest(
        val studioName: String,
        val clientName: String,
        val startTime: String,
        val endTime: String
    )
}

