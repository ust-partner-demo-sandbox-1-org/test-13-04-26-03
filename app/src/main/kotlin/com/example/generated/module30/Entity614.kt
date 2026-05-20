package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_614")
data class Entity614(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity614Repository : org.springframework.data.jpa.repository.JpaRepository<Entity614, Long> {
    fun findByField1(field1: String): List<Entity614>
    fun findByField3GreaterThan(value: Int): List<Entity614>
}

@Service
@Transactional
class Service614(private val repo: Entity614Repository) {
    fun findAll(): List<Entity614> = repo.findAll()
    fun findByName(name: String): List<Entity614> = repo.findByField1(name)
    fun save(entity: Entity614): Entity614 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity614>): List<Entity614> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
