package com.artalee.studio.kafka

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaTopicConfig {

    @Value(value = "kafka:9092")
    private val bootstrapAddress: String? = null

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs = hashMapOf<String, Any>()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress!!
        return KafkaAdmin(configs)
    }

    @Bean
    fun studioRecordsTopic(): NewTopic {
        return NewTopic("studio_records", 1, 1.toShort())
        // Параметры: имя топика, количество партиций, фактор репликации
    }
}
