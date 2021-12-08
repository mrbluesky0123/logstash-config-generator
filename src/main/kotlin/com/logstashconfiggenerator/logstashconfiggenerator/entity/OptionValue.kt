package com.logstashconfiggenerator.logstashconfiggenerator.entity

import javax.persistence.*

@Entity
@Table(name = "option_values")
data class OptionValue(
    @ManyToOne
    @JoinColumn(name = "option_id")
    val option: Option,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_value_id")
    val optionValueId: Long,

    @Column(name = "option_value", columnDefinition = "TEXT")
    val optionValue: String,

    @Column(name = "option_value_use_yn")
    val optionValueUseYn: String

) {
}