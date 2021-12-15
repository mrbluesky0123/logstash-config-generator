package com.logstashconfiggenerator.logstashconfiggenerator.service

import com.logstashconfiggenerator.logstashconfiggenerator.dao.PluginRepository
import com.logstashconfiggenerator.logstashconfiggenerator.dto.PluginBriefOutDto
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import com.logstashconfiggenerator.logstashconfiggenerator.entity.QPlugin
import com.querydsl.core.Tuple
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PluginService {

    @Autowired
    lateinit var pluginRepository: PluginRepository

    fun getPluginList(pluginType: String): List<PluginBriefOutDto>  = pluginRepository.selectPlugins(pluginType)

    fun getPlugin(pluginId: Long): Plugin? = pluginRepository.selectSpecificPlugin(pluginId)

}