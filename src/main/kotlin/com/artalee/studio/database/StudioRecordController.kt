package com.artalee.studio.database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/studio")
class StudioRecordController(@Autowired private val studioRecordService: StudioRecordService) {

    @PostMapping("/createRecord")
    fun createRecord(@RequestBody request: RecordRequest): StudioRecord {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val startTime = LocalDateTime.parse(request.startTime, formatter)
        val endTime = LocalDateTime.parse(request.endTime, formatter)

        return studioRecordService.createRecord(
            studioName = request.studioName,
            clientName = request.clientName,
            startTime = startTime,
            endTime = endTime
        )
    }

    @GetMapping("/getAllRecords")
    fun getAllRecords(): List<StudioRecord> {
        return studioRecordService.getAllRecords()
    }

    data class RecordRequest(
        val studioName: String,
        val clientName: String,
        val startTime: String,
        val endTime: String
    )
}
