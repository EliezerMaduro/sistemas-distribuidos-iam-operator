package com.IAM.documents.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.http.ResponseEntity
import org.springframework.beans.factory.annotation.Autowired
import com.IAM.documents.services.IDocumentsService
import com.IAM.documents.model.Document

@RestController
@RequestMapping("/v1/documents")
class DocumentsController @Autowired constructor(private val documentsService: IDocumentsService) {
 
    @GetMapping
    fun obtenerAllDocumentos(): List<Document> {
        return documentsService.obtenerAllDocumentos()
    }

    @GetMapping("/")
    fun obtenerDocumentos(       
        @RequestParam(required = false) limit: Int?,
        @RequestParam(required = false) page: Int?,
        @RequestParam(required = false) sort_order: String?,
        @RequestParam(required = false) sort_column: String?,
        @RequestParam(required = false) idCitizen: Int?
        ): List<Document> {
            return documentsService.obtenerDocumentos(limit, page, sort_order, sort_column, idCitizen)
    }
}
