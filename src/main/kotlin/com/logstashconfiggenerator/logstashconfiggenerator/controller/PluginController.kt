package com.logstashconfiggenerator.logstashconfiggenerator.controller

import com.logstashconfiggenerator.logstashconfiggenerator.service.PluginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/plugin")
class PluginController {

    @Autowired
    lateinit var pluginService: PluginService

    @GetMapping("/list/{pluginType}")
    fun getPluginList(@PathVariable pluginType: String) = pluginService.getPluginList(pluginType)

    @GetMapping("/{pluginId}")
    fun getPlugin(@PathVariable pluginId: Long) = pluginService.getPlugin(pluginId)

}