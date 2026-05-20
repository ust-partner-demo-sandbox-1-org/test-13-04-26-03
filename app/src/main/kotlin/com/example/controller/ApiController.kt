package com.example.controller

import com.example.service.DataService
import com.example.model.DataEntity
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid

@RestController
@RequestMapping("/api/v1")
class ApiController(private val dataService: DataService) {

    @GetMapping("/data")
    fun getAllData(): List<DataEntity> = dataService.findAll()

    @GetMapping("/data/{id}")
    fun getById(@PathVariable id: Long): DataEntity = dataService.findById(id)

    @PostMapping("/data")
    fun create(@Valid @RequestBody entity: DataEntity): DataEntity = dataService.save(entity)

    @DeleteMapping("/data/{id}")
    fun delete(@PathVariable id: Long) = dataService.delete(id)
}