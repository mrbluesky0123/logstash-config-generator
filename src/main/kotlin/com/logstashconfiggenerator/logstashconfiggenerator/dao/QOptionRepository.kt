package com.logstashconfiggenerator.logstashconfiggenerator.dao

import com.logstashconfiggenerator.logstashconfiggenerator.entity.Option
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import org.springframework.stereotype.Repository

@Repository
interface QOptionRepository {
    fun selectOptions(pluginId: Long): List<Option>
    fun selectSpecificOption(optionId: Long): Option?
}