/*import com.artalee.studio.database.StudioRecordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class DatabaseInitializer(@Autowired private val studioRecordService: StudioRecordService) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val date = LocalDateTime.now()
        val startTime = LocalDateTime.parse(date.format(formatter), formatter)
        val endTime = startTime.plusHours(2)

        studioRecordService.createRecord(
            studioName = "Studio Test",
            clientName = "Test Client",
            date = date,
            startTime = startTime,
            endTime = endTime
        )
    }
}

 */
