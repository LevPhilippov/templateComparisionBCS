package ru.bcs.common.dto

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import ru.bcs.cctreceiptsenderservice.db.entity.ReceiptEntity
import ru.bcs.cctreceiptsenderservice.db.entity.ReceiptStatus
import ru.bcs.common.dto.config.TemplateMapProperties
import ru.bcs.common.dto.config.TemplateProperties
import ru.bcs.common.dto.service.TemplateService
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.ThreadLocalRandom

@Service
class HTMLGenerator(private val templateService: TemplateService) {

    @PostConstruct
    fun generateHTML() {
        saveToFile(templateService.processTemplate(generateEntity()).also { println(it) })
    }

    fun generateEntity(): ReceiptEntity {
       return ReceiptEntity(
            UUID.randomUUID(),
            UUID.randomUUID(),
            mapOf("firstName" to "Лионель", "secondName" to "Месси"),
           "https://start.spring.io",
//           if (ThreadLocalRandom.current().nextBoolean())
//               UUID.fromString("9cebfe8a-90d5-40b2-827b-a01fec98a391")
//           else
               UUID.fromString("fe991008-d8ff-4c37-bf05-dd7390399734"),
           "routingKey",
           "fiscalSign",
           "fiscalDriveNumber",
           "fiscalDocumentNumber",
           "cct-receipt@bcs.ru",
           UUID.randomUUID(),
           ReceiptStatus.ENRICHED,
           LocalDateTime.now()
        )
    }

    private fun saveToFile(text: String) {
        val folder = Paths.get("html")
        if(!Files.exists(folder)) {
            Files.createDirectory(folder)
        }
        val file = Paths.get(folder.toString(), UUID.randomUUID().toString()+".html")
        Files.createFile(file)
        Files.write(file,text.toByteArray())
    }

}