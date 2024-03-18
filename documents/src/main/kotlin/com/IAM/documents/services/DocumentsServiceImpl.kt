package com.IAM.documents.services;

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestParam
import com.IAM.documents.repository.IDocumentsRepository
import com.IAM.documents.model.Document
import com.IAM.documents.services.IDocumentsService


@Service
@Transactional
class DocumentsServiceImpl @Autowired constructor(private val documentsRepository: IDocumentsRepository) : IDocumentsService{
    
    override fun obtenerAllDocumentos(): List<Document> {
        return documentsRepository.findAll() ?: emptyList()
    }

    override fun obtenerDocumentos(limit: Int?, page: Int?, sort_order: String?, sort_column: String?, idCitizen: Int?):  List<Document> {
            return documentsRepository.findAllByIdCitizen(idCitizen)?: emptyList()
    }
}
