package com.artalee.studio


import com.artalee.studio.database.StudioRecordRepository
import com.artalee.studio.database.StudioRecordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDateTime

@SpringBootApplication
class StudioApplication

fun main(args: Array<String>) {

	runApplication<StudioApplication>(*args)
}
