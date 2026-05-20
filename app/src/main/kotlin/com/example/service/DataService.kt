package com.example.service

import com.example.model.DataEntity
import com.example.repository.DataRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DataService(private val repository: DataRepository) {

    fun findAll(): List<DataEntity> = repository.findAll()

    fun findById(id: Long): DataEntity =
        repository.findById(id).orElseThrow { NoSuchElementException("Not found: $id") }

    fun save(entity: DataEntity): DataEntity = repository.save(entity)

    fun delete(id: Long) = repository.deleteById(id)
}