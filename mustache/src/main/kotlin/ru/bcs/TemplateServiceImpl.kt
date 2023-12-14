package ru.bcs

import com.samskivert.mustache.Mustache
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration
import org.springframework.boot.autoconfigure.mustache.MustacheResourceTemplateLoader
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import ru.bcs.cctreceiptsenderservice.db.entity.ReceiptEntity
import ru.bcs.common.dto.config.TemplateMapProperties
import ru.bcs.common.dto.service.TemplateService
import java.io.ByteArrayOutputStream
import java.io.OutputStreamWriter
import java.io.StringReader
import java.io.StringWriter
import java.nio.charset.Charset
import java.util.*


@Service
class TemplateServiceImpl(private val compiler: Mustache.Compiler, private val properties: TemplateMapProperties) :
    TemplateService {

     override fun processTemplate(entity: ReceiptEntity): String {
        val templateProperties = properties.templatesMap[entity.templateId]!!
         val values = entity.templateValues.toMutableMap()
             .let {
                 it["link"] = entity.link
                 it
             }
         val classPathResource = ClassPathResource("templates/${templateProperties.filename}")
         val template = compiler.compile(classPathResource.getContentAsString(Charset.forName("UTF-8")))

         return StringWriter().use {
             template.execute(values,it)
             it.toString()
         }
    }
}
