package com.iam.create_package.model;

import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.ElementCollection

@Entity
@Table(name="packages")
class PackageModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val packageName: String,
    val idCitizen: Int,
    val userName: String,
    @ElementCollection
    val documentUrls: List<String>
)
