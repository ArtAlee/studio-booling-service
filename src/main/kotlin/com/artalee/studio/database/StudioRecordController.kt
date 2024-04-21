package com.artalee.studio.database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/studio")
class StudioRecordController(@Autowired private val studioRecordService: StudioRecordService) {

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
            ResponseEntity.ok(record)
        } catch (e: IllegalStateException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @GetMapping("/getAllRecords")
    fun getAllRecords(): ResponseEntity<List<StudioRecord>> {
        return ResponseEntity.ok(studioRecordService.getAllRecords())
    }

    data class RecordRequest(
        val studioName: String,
        val clientName: String,
        val startTime: String,
        val endTime: String
    )
}

