package ru.bcs.common.dto.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(basePackageClasses = [TemplateMapProperties::class])
class TemplateConfiguration {

}