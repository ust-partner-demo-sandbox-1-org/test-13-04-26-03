package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_172")
data class Entity172(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity172Repository : org.springframework.data.jpa.repository.JpaRepository<Entity172, Long> {
    fun findByField1(field1: String): List<Entity172>
    fun findByField3GreaterThan(value: Int): List<Entity172>
}

@Service
@Transactional
class Service172(private val repo: Entity172Repository) {
    fun findAll(): List<Entity172> = repo.findAll()
    fun findByName(name: String): List<Entity172> = repo.findByField1(name)
    fun save(entity: Entity172): Entity172 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity172>): List<Entity172> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
