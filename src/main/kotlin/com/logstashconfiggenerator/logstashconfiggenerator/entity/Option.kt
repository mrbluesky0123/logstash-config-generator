package com.logstashconfiggenerator.logstashconfiggenerator.entity

import com.logstashconfiggenerator.core.base.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "options")
data class Option(
    @ManyToOne
    @JoinColumn(name="plugin_id")
    val plugin: Plugin,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="option_id")
    val optionId: Long,

    @Column(name="option_key")
    val optionKey: String,

    @Column(name = "option_required_yn")
    val optionRequiredYn: String,

    @Column(name = "option_input_type")
    val optionInputType: String,

    @Column(name = "option_use_yn")
    val optionUseYn: String,

    @Column(name = "option_description", columnDefinition = "TEXT")
    val optionDescription: String
): BaseEntity() {
}