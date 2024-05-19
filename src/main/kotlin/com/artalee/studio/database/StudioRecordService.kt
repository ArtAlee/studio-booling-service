package com.artalee.studio.database

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class StudioRecordService(@Autowired private val kafkaTemplate: KafkaTemplate<String, StudioRecord>, @Autowired private val repository: StudioRecordRepository) {

    private val topicName = "studio_records"
    private val log = LoggerFactory.getLogger(StudioRecordService::class.java)

    fun createRecord(studioName: String, clientName: String, startTime: LocalDateTime, endTime: LocalDateTime): StudioRecord? {
        if (isTimeAvailable(studioName, startTime, endTime)) {
            val record = StudioRecord(studioName = studioName, clientName = clientName, startTime = startTime, endTime = endTime)
            kafkaTemplate.send(topicName, record)
            return record
        } else {
            throw IllegalStateException("The time slot is not available.")
        }
    }

    fun isTimeAvailable(studioName: String, startTime: LocalDateTime, endTime: LocalDateTime): Boolean {
        val count = repository.countByTimeOverlap(studioName, startTime, endTime)
        if (startTime.isAfter(endTime)) {
            log.error("Incorrect time interval is presented")
        }
        return count == 0L
    }

    fun getAllRecords(): List<StudioRecord> {
        return repository.findAll()
    }
}