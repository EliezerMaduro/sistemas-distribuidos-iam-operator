package com.iam.create_package.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository

import com.iam.create_package.model.PackageModel

@Repository
interface IPackageRepository : JpaRepository<PackageModel,Int>{
    fun findByIdCitizen(idCitizen: Int): List<PackageModel>
}
