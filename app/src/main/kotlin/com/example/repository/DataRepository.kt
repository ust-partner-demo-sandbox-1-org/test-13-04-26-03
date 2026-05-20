package com.example.repository

import com.example.model.DataEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DataRepository : JpaRepository<DataEntity, Long>