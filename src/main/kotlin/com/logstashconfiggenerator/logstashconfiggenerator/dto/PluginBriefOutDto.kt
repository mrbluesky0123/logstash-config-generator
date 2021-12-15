package com.logstashconfiggenerator.logstashconfiggenerator.dto

import com.logstashconfiggenerator.core.base.BaseOutDto

class PluginBriefOutDto(
    val pluginId: Long,
    val pluginName: String,
    val pluginDescription: String
): BaseOutDto() {
}