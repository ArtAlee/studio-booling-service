package com.artalee.studio.database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class KafkaConsumerService(@Autowired private val repository: StudioRecordRepository) {

    @KafkaListener(topics = ["studio_records"], groupId = "studio-group")
    @Transactional
    fun listen(record: StudioRecord) {
        repository.save(record)
    }
}