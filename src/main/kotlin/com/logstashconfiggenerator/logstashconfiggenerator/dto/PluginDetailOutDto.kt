package com.logstashconfiggenerator.logstashconfiggenerator.dto

import com.logstashconfiggenerator.core.base.BaseOutDto

data class PluginDetailOutDto(
    val pluginId: Long,
    val pluginType: String,
    val pluginName: String,
    val pluginContents: String,
    val pluginDescription: String,
    val options: List<OptionDto>?
): BaseOutDto() {
}