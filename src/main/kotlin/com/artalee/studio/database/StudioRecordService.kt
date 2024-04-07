package com.artalee.studio.database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class StudioRecordService(@Autowired private val repository: StudioRecordRepository) {

    fun createRecord(studioName: String, clientName: String, date: LocalDateTime, startTime: LocalDateTime, endTime: LocalDateTime): StudioRecord {
        val record = StudioRecord(name = studioName, client = clientName, date = date, startTime = startTime, endTime = endTime)
        return repository.save(record)
    }

}


