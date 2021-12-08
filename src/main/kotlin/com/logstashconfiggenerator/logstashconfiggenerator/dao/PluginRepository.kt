package com.logstashconfiggenerator.logstashconfiggenerator.dao

import com.logstashconfiggenerator.logstashconfiggenerator.entity.Plugin
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PluginRepository: JpaRepository<Plugin, Long>, QPluginRepository {
}