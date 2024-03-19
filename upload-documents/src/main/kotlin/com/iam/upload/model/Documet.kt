package com.iam.upload.model

import java.time.LocalDateTime
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
@Table(name="documentos")
class Document(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val idCitizen: Int?,
    val name: String,
    val createdAt: LocalDateTime,
    val type: String,
    val fileName: String,
    val url: String,
)

