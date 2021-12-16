package com.logstashconfiggenerator.common.repository

import com.logstashconfiggenerator.common.entity.ResponseCode
import org.springframework.data.jpa.repository.JpaRepository

interface ResponseCodeRepository: JpaRepository<Long, ResponseCode> {
    fun findByResponseCode1AndResponseCode2(responseCode1: String, responseCode2: String): ResponseCode?
}