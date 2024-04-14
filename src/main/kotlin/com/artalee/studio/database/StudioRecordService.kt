package com.artalee.studio.database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class StudioRecordService(@Autowired private val kafkaTemplate: KafkaTemplate<String, StudioRecord>) {

    private val topicName = "studio_records"


    fun createRecord(
        studioName: String,
        clientName: String,
        startTime: LocalDateTime,
        endTime: LocalDateTime
    ): StudioRecord {
        val record =
            StudioRecord(studioName = studioName, clientName = clientName, startTime = startTime, endTime = endTime)
        kafkaTemplate.send(topicName, record)
        return record
    }
}
