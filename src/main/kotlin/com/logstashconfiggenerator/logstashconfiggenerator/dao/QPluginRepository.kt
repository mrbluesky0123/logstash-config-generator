package com.logstashconfiggenerator.logstashconfiggenerator.dao

import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import com.logstashconfiggenerator.logstashconfiggenerator.entity.QPlugin
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
interface QPluginRepository {
    fun selectPlugins(pluginType: String): List<Plugin>
    fun selectSpecificPlugin(pluginId: Long): Plugin?
}