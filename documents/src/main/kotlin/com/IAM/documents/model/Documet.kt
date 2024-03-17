package com.IAM.documents.model

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
    val owner: String,
    val identification: Int,
    val url: String,
    val createdAt: LocalDateTime,
    val type: String,
    val fileName: String
)

