package com.iam.create_package.controller;

import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired

import com.iam.create_package.service.IPackageService
import com.iam.create_package.service.PackageServiceImp
import com.iam.create_package.model.PackageModel


@RestController
@RequestMapping("/v1/documents")
class packageController (private val packageService: PackageServiceImp){

    @PostMapping("/create-package")
    fun createPackage(@RequestBody request: PackageModel):ResponseEntity<PackageModel> {
        val savedPackage = packageService.savePackage(request)
        return ResponseEntity(savedPackage, HttpStatus.CREATED)
    }
    
    @GetMapping("/create-package/{idCitizen}")
    fun findByIdCitizen(@PathVariable idCitizen: Int): ResponseEntity<List<PackageModel>> {
        val packages = packageService.getPackagesByCitizenId(idCitizen)
        return if (packages.isNotEmpty()) {
            ResponseEntity(packages, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}