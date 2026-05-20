package com.example.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "data_records")
data class DataEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @field:NotBlank
    val name: String = "",

    val description: String? = null,

    @Column(name = "metadata", columnDefinition = "TEXT")
    val metadata: String? = null
)