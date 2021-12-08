package com.logstashconfiggenerator.logstashconfiggenerator.dao

import com.logstashconfiggenerator.core.config.QueryDslConfiguration
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
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
    fun testSelectPlugins() {
        // Input
        val inputPluginList: List<Plugin> = pluginRepository.selectPlugins("INPUT")
        assertEquals("jdbc", inputPluginList[0].pluginName)
        // Output
        val outputPluginList: List<Plugin> = pluginRepository.selectPlugins("OUTPUT")
        assertEquals("elasticsearch", outputPluginList[0].pluginName)
        // Filter
        val filterPluginList: List<Plugin> = pluginRepository.selectPlugins("FILTER")
        assertEquals("ruby", filterPluginList[0].pluginName)
    }

    @Test
    fun testSelectSpecificPlugins() {
        val pluginId: Long = 1
        val plugin: Plugin = pluginRepository.selectSpecificPlugin(pluginId)
        assertEquals("jdbc", plugin.pluginName)
    }
}