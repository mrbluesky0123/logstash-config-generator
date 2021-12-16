package com.logstashconfiggenerator.logstashconfiggenerator.service

import ch.qos.logback.classic.Logger
import com.logstashconfiggenerator.logstashconfiggenerator.dao.PluginRepository
import com.logstashconfiggenerator.logstashconfiggenerator.dto.PluginBriefOutDto
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Option
import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.slf4j.LoggerFactory

@ExtendWith(MockitoExtension::class)
class PluginServiceTest {

    @InjectMocks
    lateinit var pluginService: PluginService

    @Mock
    lateinit var  pluginRepository: PluginRepository

    protected final val log = LoggerFactory.getLogger(this::class.java) as Logger

    @Test
    fun testGetPluginList() {
        val given = this.getFakeList()
        given(pluginRepository.selectPlugins("INPUT")).willReturn(given)

        val actual = pluginService.getPluginList("INPUT")
        assertEquals(1, actual[0].pluginId)
        assertEquals("jdbc", actual[0].pluginName)
        assertEquals("JDBC input plugin", actual[0].pluginDescription)
    }

    @Test
    fun testGetPlugin() {
        // given
        val expected = Plugin(
            pluginId = 1,
            pluginType = "INPUT",
            pluginName = "jdbc",
            pluginContents = "jdbc {\n\t\n}",
            pluginUseYn = "Y",
            pluginDescription = "JDBC input plugin",
            options = listOf<Option>(
                Option(
                    pluginId = 1,
                    optionId = 1,
                    optionKey = "jdbc_connection_string",
                    optionRequiredYn = "Y",
                    optionInputType = "string",
                    optionUseYn="Y",
                    optionDescription="JDBC input plugin",
                    optionValueExample= ""
                )
            )
        )
        given(pluginRepository.selectSpecificPlugin(1)).willReturn(expected)

        // when
        val actual = pluginService.getPlugin(1)

        assertEquals("jdbc_connection_string", actual!!.options!![0].optionKey)

    }

    private fun getFakeList(): List<Plugin> {
        var fakeList: ArrayList<Plugin> = ArrayList()
        val expected = Plugin(
            pluginId = 1,
            pluginType = "INPUT",
            pluginName = "jdbc",
            pluginContents = "jdbc {\n\t\n}",
            pluginUseYn = "Y",
            pluginDescription = "JDBC input plugin",
            options = listOf<Option>(
                Option(
                    pluginId = 1,
                    optionId = 1,
                    optionKey = "jdbc_connection_string",
                    optionRequiredYn = "Y",
                    optionInputType = "string",
                    optionUseYn="Y",
                    optionDescription="JDBC input plugin",
                    optionValueExample= ""
                )
            )
        )
        fakeList.add(expected)
        return fakeList
    }

}