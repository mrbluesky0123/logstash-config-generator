package com.logstashconfiggenerator.common.entity

import com.logstashconfiggenerator.core.base.BaseEntity
import javax.persistence.*

@Entity
@Table(name="response_code")
data class ResponseCode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="response_code_id")
    val responseCodeId: Long,

    @Column(name="response_code_1")
    val responseCode1: String,

    @Column(name="response_code_2")
    val responseCode2: String,

    @Column(name="response_message")
    val responseMessage: String
): BaseEntity()
