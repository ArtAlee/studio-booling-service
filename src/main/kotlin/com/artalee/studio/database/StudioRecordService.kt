package com.artalee.studio.database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class StudioRecordService(@Autowired private val repository: StudioRecordRepository) {

    fun createRecord(studioName: String, clientName: String, startTime: LocalDateTime, endTime: LocalDateTime): StudioRecord {
        val record = StudioRecord(studioName = studioName, clientName = clientName, startTime = startTime, endTime = endTime)
        return repository.save(record)
    }

    fun deleteRecord(id: Long) {
        repository.deleteById(id)
    }

    fun getAllRecords(): List<StudioRecord> {
        return repository.findAll()
    }
}
