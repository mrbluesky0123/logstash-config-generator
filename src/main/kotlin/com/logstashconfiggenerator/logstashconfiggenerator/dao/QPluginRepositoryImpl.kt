package com.logstashconfiggenerator.logstashconfiggenerator.dao

import com.logstashconfiggenerator.logstashconfiggenerator.dto.PluginBriefOutDto
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import com.logstashconfiggenerator.logstashconfiggenerator.entity.QPlugin
import com.querydsl.core.Tuple
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory

class QPluginRepositoryImpl(val jpaQueryFactory: JPAQueryFactory): QPluginRepository {

    override fun selectPlugins(pluginType: String): List<PluginBriefOutDto> {
        val plugin: QPlugin = QPlugin.plugin
        val pluginList: List<PluginBriefOutDto> = jpaQueryFactory.select(
            Projections.constructor(PluginBriefOutDto::class.java,
                plugin.pluginId,
                plugin.pluginName,
                plugin.pluginDescription))
            .from(plugin)
            .where(plugin.pluginType.eq(pluginType))
            .fetch()
        return pluginList
    }

    override fun selectSpecificPlugin(pluginId: Long): Plugin? {
        val plugin: QPlugin = QPlugin.plugin
        val resultPlugin: Plugin? = jpaQueryFactory.selectFrom(plugin)
            .where(plugin.pluginId.eq(pluginId))
            .fetchOne()
        return resultPlugin
    }


}