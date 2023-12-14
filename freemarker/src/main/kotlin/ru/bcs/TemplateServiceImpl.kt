package ru.bcs

import freemarker.template.Configuration
import org.springframework.stereotype.Service
import ru.bcs.cctreceiptsenderservice.db.entity.ReceiptEntity
import ru.bcs.common.dto.config.TemplateMapProperties
import ru.bcs.common.dto.service.TemplateService
import java.io.ByteArrayOutputStream
import java.io.OutputStreamWriter
import java.io.StringWriter

import java.util.*


@Service
class TemplateServiceImpl(private val configuration: Configuration ,private val properties: TemplateMapProperties) :
    TemplateService {

     override fun processTemplate(entity: ReceiptEntity): String {
        val templateProperties = properties.templatesMap[entity.templateId]!!
         val values = entity.templateValues.toMutableMap()
             .let {
                 it["link"] = entity.link
                 it
             }
         val template = configuration.getTemplate(templateProperties.filename)
         return StringWriter().use {
             template.process(values,it)
             it.toString()
         }

    }
}
