package com.logstashconfiggenerator.common.exception

import com.logstashconfiggenerator.common.repository.ResponseCodeRepository
import com.logstashconfiggenerator.core.exception.BaseException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

class BusinessException (
    override val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    override val responseCode: String,
    override var responseMessage: String?
) : BaseException(httpStatus, responseCode, responseMessage) {
    @Autowired
    lateinit var responseCodeRepository: ResponseCodeRepository

    constructor(responseCode: String, responseMessage: String) :
            this(HttpStatus.INTERNAL_SERVER_ERROR, responseCode, responseMessage)
    constructor(responseCode: String): this(HttpStatus.INTERNAL_SERVER_ERROR, responseCode, null) {
        val responseCode1 = responseCode.substring(0..1)
        val responseCode2 = responseCode.substring(2..3)
        this.responseMessage =
            responseCodeRepository.findByResponseCode1AndResponseCode2(responseCode1, responseCode2)?.responseMessage
    }
}