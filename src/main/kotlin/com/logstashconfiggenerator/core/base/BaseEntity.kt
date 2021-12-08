package com.logstashconfiggenerator.core.base

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity: BaseObject() {
    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null

    @Column(name = "creator_id")
    var creatorId: String? = null

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null

    @Column(name = "updater_id")
    var updaterId: String? = null
}