package com.logstashconfiggenerator.logstashconfiggenerator.dao

import ch.qos.logback.classic.Logger
import com.logstashconfiggenerator.core.config.QueryDslConfiguration
import com.logstashconfiggenerator.logstashconfiggenerator.dto.PluginBriefOutDto
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import com.logstashconfiggenerator.logstashconfiggenerator.entity.QPlugin
import com.querydsl.core.Tuple
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

//@ExtendWith(SpringExtension::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(QueryDslConfiguration::class)
class PluginRepositoryTest(@Autowired val pluginRepository: PluginRepository) {

    protected final val log = LoggerFactory.getLogger(this::class.java) as Logger

    @Test
    fun testSelectPlugins() {
        // Input
        val inputPluginList: List<Plugin> = pluginRepository.selectPlugins("INPUT")
        log.info("#### pluginId = {}, pluginName = {}, pluginDescription = {}",
            inputPluginList[0].pluginId,
            inputPluginList[0].pluginName,
            inputPluginList[0].pluginDescription)
        assertEquals("jdbc", inputPluginList[0].pluginName)
        // Output
        val outputPluginList: List<Plugin> = pluginRepository.selectPlugins("OUTPUT")
        log.info("#### pluginId = {}, pluginName = {}, pluginDescription = {}",
            outputPluginList[0].pluginId,
            outputPluginList[0].pluginName,
            outputPluginList[0].pluginDescription)
        assertEquals("elasticsearch", outputPluginList[0].pluginName)
        // Filter
        val filterPluginList: List<Plugin> = pluginRepository.selectPlugins("FILTER")
        log.info("#### pluginId = {}, pluginName = {}, pluginDescription = {}",
            filterPluginList[0].pluginId,
            filterPluginList[0].pluginName,
            filterPluginList[0].pluginDescription)
        assertEquals("ruby", filterPluginList[0].pluginName)
    }

    @Test
    fun testSelectSpecificPlugins() {
        val pluginId: Long = 1
        val plugin: Plugin? = pluginRepository.selectSpecificPlugin(pluginId)
        log.info("#### plugin = {} ", plugin.toString())
        assertEquals("jdbc", plugin!!.pluginName)
    }
}