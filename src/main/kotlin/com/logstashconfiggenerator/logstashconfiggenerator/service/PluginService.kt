package com.logstashconfiggenerator.logstashconfiggenerator.service

import com.logstashconfiggenerator.logstashconfiggenerator.dao.PluginRepository
import com.logstashconfiggenerator.logstashconfiggenerator.dto.OptionDto
import com.logstashconfiggenerator.logstashconfiggenerator.dto.PluginBriefOutDto
import com.logstashconfiggenerator.logstashconfiggenerator.dto.PluginDetailOutDto
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import com.logstashconfiggenerator.logstashconfiggenerator.entity.QPlugin
import com.querydsl.core.Tuple
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PluginService {

    @Autowired
    lateinit var pluginRepository: PluginRepository

    fun getPluginList(pluginType: String): List<PluginBriefOutDto> {
        val pluginList: List<Plugin> = pluginRepository.selectPlugins(pluginType)
        val pluginDtoList: ArrayList<PluginBriefOutDto> = ArrayList()
        for(plugin in pluginList) {
            pluginDtoList.add(
                PluginBriefOutDto(
                    pluginId = plugin.pluginId,
                    pluginName = plugin.pluginName,
                    pluginDescription = plugin.pluginDescription
                )
            )
        }
        return pluginDtoList
    }

    fun getPlugin(pluginId: Long): PluginDetailOutDto? {
        val plugin: Plugin = pluginRepository.selectSpecificPlugin(pluginId)
            ?: throw RuntimeException()    // need to be defined
        var options = ArrayList<OptionDto>()
        for(option in plugin.options) {
            options.add(
                OptionDto(
                    optionKey = option.optionKey,
                    optionRequiredYn = option.optionRequiredYn,
                    optionDescription = option.optionDescription,
                    optionValueExample = option.optionValueExample
                )
            )
        }
        var pluginDetailOutDto: PluginDetailOutDto = PluginDetailOutDto(
            pluginId = plugin.pluginId,
            pluginType = plugin.pluginType,
            pluginName = plugin.pluginName,
            pluginContents = plugin.pluginContents,
            pluginDescription = plugin.pluginDescription,
            options = options
        )
        return pluginDetailOutDto
    }

}