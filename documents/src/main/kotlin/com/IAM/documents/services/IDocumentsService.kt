package com.IAM.documents.services;

import com.IAM.documents.model.Document

interface IDocumentsService {
    fun obtenerDocumentos(limit: Int?, page: Int?, sort_order: String?, sort_column: String?, idCitizen: Int?): List<Document>
    fun obtenerAllDocumentos(): List<Document>
}
