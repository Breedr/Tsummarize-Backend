package uk.breedrapps.tsummarizebackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Tsum (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @get: NotBlank
        val name: String = "",

        @get: NotBlank
        val description: String = "",

        @get: NotBlank
        val imageUrl: String = ""
)