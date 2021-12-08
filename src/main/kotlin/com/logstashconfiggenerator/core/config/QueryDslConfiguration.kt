package com.logstashconfiggenerator.core.config
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
@TestConfiguration
class QueryDslConfiguration (
    @PersistenceContext
    val entityManager: EntityManager ){
    @Bean
    fun jpaQueryFactory () = JPAQueryFactory(entityManager)
}