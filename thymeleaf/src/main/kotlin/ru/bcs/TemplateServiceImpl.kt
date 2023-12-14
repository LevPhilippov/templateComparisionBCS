package ru.bcs

import org.springframework.stereotype.Service
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import ru.bcs.cctreceiptsenderservice.db.entity.ReceiptEntity
import ru.bcs.common.dto.config.TemplateMapProperties
import ru.bcs.common.dto.service.TemplateService
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.attribute.FileAttribute
import java.util.UUID
import kotlin.io.path.createFile
import kotlin.io.path.exists


@Service
class TemplateServiceImpl(private val templateEngine: TemplateEngine, private val properties: TemplateMapProperties) :
    TemplateService {

     override fun processTemplate(entity: ReceiptEntity) : String {
        val templateProperties = properties.templatesMap[entity.templateId]!!
         val values = entity.templateValues.toMutableMap()
             .let {
                 it["link"] = entity.link
                 it
             }
        return templateEngine.process(templateProperties.filename, getContext(values))
    }

    private fun getContext(templateValues: Map<String, String>): Context =
        Context().also { it.setVariable("templateValues", templateValues) }

}
