package com.example.generated.module35

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_704")
data class Entity704(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity704Repository : org.springframework.data.jpa.repository.JpaRepository<Entity704, Long> {
    fun findByField1(field1: String): List<Entity704>
    fun findByField3GreaterThan(value: Int): List<Entity704>
}

@Service
@Transactional
class Service704(private val repo: Entity704Repository) {
    fun findAll(): List<Entity704> = repo.findAll()
    fun findByName(name: String): List<Entity704> = repo.findByField1(name)
    fun save(entity: Entity704): Entity704 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity704>): List<Entity704> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
