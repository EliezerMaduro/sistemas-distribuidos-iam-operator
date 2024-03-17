package com.IAM.documents.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity
import org.springframework.beans.factory.annotation.Autowired
import com.IAM.documents.services.IDocumentsService
import com.IAM.documents.model.Document

@RestController
@RequestMapping("/v1/documents")
class DocumentsController{

    @Autowired 
    private val documentsService: IDocumentsService? = null

    @GetMapping("/{id}")
    fun obtenerDocumentos(@PathVariable id: Int): ResponseEntity<Document> {
        val documento = documentsService?.obtenerDocumentos(id)
        return if (documento != null) {
            ResponseEntity.ok(documento)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
