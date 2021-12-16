package com.logstashconfiggenerator.logstashconfiggenerator.entity

import com.logstashconfiggenerator.core.base.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "plugins")
data class Plugin(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plugin_id")
    val pluginId: Long,

    @Column(name = "plugin_type")
    val pluginType: String,

    @Column(name = "plugin_name")
    val pluginName: String,

    @Column(name = "plugin_contents", columnDefinition = "TEXT")
    val pluginContents: String,

    @Column(name = "plugin_use_yn")
    val pluginUseYn: String,

    @Column(name = "plugin_description", columnDefinition = "TEXT")
    val pluginDescription: String,

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="plugin_id")
    val options: List<Option>

): BaseEntity()