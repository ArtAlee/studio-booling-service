package com.artalee.studio.kafka

import com.artalee.studio.database.StudioRecord
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class KafkaConsumerService {

    @KafkaListener(topics = ["studio_records"], groupId = "studio-group")
    fun listen(record: ConsumerRecord<String, StudioRecord>) {
        println("Received: ${record.value()}")
    }
}
