package com.logstashconfiggenerator.logstashconfiggenerator.dao

import com.logstashconfiggenerator.logstashconfiggenerator.entity.Option
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import com.logstashconfiggenerator.logstashconfiggenerator.entity.QOption
import com.logstashconfiggenerator.logstashconfiggenerator.entity.QPlugin
import com.querydsl.jpa.impl.JPAQueryFactory

class QOptionRepositoryImpl(val jpaQueryFactory: JPAQueryFactory): QOptionRepository {
    override fun selectOptions(pluginId: Long): List<Option> {
        val option: QOption = QOption.option
        val optionList: List<Option> = jpaQueryFactory.selectFrom(option)
            .where(option.pluginId.eq(pluginType))
            .fetch()
        return pluginList
    }

    override fun selectSpecificOption(optionId: Long): Option? {
        TODO("Not yet implemented")
    }
}