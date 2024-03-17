package com.IAM.documents.repository;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.IAM.documents.model.Document


@Repository 
interface IDocumentsRepository : JpaRepository<Document,Int> {
    fun findByOwner(owner: String): List<Document>

}
