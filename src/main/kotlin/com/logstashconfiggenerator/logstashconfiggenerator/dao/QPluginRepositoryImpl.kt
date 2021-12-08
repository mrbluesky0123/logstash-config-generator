package com.logstashconfiggenerator.logstashconfiggenerator.dao

import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import com.logstashconfiggenerator.logstashconfiggenerator.entity.QPlugin
import com.querydsl.jpa.impl.JPAQueryFactory

class QPluginRepositoryImpl(val jpaQueryFactory: JPAQueryFactory): QPluginRepository {

    override fun selectInputPlugins(): List<Plugin> {
        val plugin: QPlugin = QPlugin.plugin
        val pluginList: List<Plugin> = jpaQueryFactory.selectFrom(plugin)
            .where(plugin.pluginType.eq("INPUT"))
            .fetch()
        return pluginList
    }

}