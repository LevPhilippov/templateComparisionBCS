package ru.bcs.common.dto.config

import org.springframework.boot.context.properties.ConfigurationProperties
import java.util.*
import kotlin.collections.HashMap

@ConfigurationProperties(prefix = "bcs")
data class TemplateMapProperties(val templatesMap: HashMap<UUID, TemplateProperties>)

data class TemplateProperties(val filename: String, val emailFrom: String)