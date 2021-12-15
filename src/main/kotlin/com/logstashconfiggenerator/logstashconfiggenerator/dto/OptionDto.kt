package com.logstashconfiggenerator.logstashconfiggenerator.dto

data class OptionDto(
    val optionKey: String,
    val optionRequiredYn: String,
    val optionDescription: String,
    val optionValueExample: String
) {
}