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
        val expected = this.getFakeList()
        given(pluginRepository.selectPlugins("INPUT")).willReturn(expected)

        val actual = pluginService.getPluginList("INPUT")
        assertEquals(expected[0].pluginId, actual[0].pluginId)
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

        assertEquals(expected.pluginId, actual!!.pluginId)
        assertEquals(expected.options[0].pluginId, actual!!.options[0].pluginId)

    }

    private fun getFakeList(): List<PluginBriefOutDto> {
        var fakeList: ArrayList<PluginBriefOutDto> = ArrayList()
        val pluginBriefOutDto: PluginBriefOutDto =
            PluginBriefOutDto(pluginId = 1, pluginName = "jdbc", pluginDescription = "JDBC input plugin")
        fakeList.add(pluginBriefOutDto)
        return fakeList
    }

}