package com.logstashconfiggenerator.logstashconfiggenerator.dao

import com.logstashconfiggenerator.core.config.QueryDslConfiguration
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension

//@ExtendWith(SpringExtension::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(QueryDslConfiguration::class)
class QPluginRespositoryTest(@Autowired val pluginRepository: PluginRepository) {
    @Test
    fun testSelectInputPlugins() {
        val pluginList: List<Plugin> = pluginRepository.selectInputPlugins()
        Assertions.assertEquals("jdbc", pluginList[0].pluginName)
    }
}