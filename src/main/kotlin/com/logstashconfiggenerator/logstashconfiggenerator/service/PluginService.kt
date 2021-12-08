package com.logstashconfiggenerator.logstashconfiggenerator.service

import com.logstashconfiggenerator.logstashconfiggenerator.dao.PluginRepository
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class PluginService(val pluginRepository: PluginRepository) {
}