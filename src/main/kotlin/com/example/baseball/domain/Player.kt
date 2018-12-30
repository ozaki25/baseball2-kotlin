package com.example.baseball.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.*

@Entity
data class Player(
        @Id
        @GeneratedValue
        val id: Long? = null,
        @get:NotEmpty
        val name: String? = null,
        @get:NotNull
        @get:Min(value = 0)
        @get:Max(value = 150)
        val age: Int? = null,
        @get:Size(max = 20)
        val team: String? = null,
        val position: String? = null
)
