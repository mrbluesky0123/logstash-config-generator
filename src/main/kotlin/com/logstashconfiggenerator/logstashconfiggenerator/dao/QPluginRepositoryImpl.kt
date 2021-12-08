package com.logstashconfiggenerator.logstashconfiggenerator.dao

import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import com.logstashconfiggenerator.logstashconfiggenerator.entity.QPlugin
import com.querydsl.jpa.impl.JPAQueryFactory

class QPluginRepositoryImpl(val jpaQueryFactory: JPAQueryFactory): QPluginRepository {

    override fun selectPlugins(pluginType: String): List<Plugin> {
        val plugin: QPlugin = QPlugin.plugin
        val pluginList: List<Plugin> = jpaQueryFactory.selectFrom(plugin)
            .where(plugin.pluginType.eq(pluginType))
            .fetch()
        return pluginList
    }

    override fun selectSpecificPlugin(pluginId: Long): Plugin? {
        val plugin: QPlugin = QPlugin.plugin
        val resultPlugin: Plugin = jpaQueryFactory.selectFrom(plugin)
            .where(plugin.pluginId.eq(pluginId))
            .fetch()
        return resultPlugin
    }


}