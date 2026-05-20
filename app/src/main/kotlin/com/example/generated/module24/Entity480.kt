package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_480")
data class Entity480(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity480Repository : org.springframework.data.jpa.repository.JpaRepository<Entity480, Long> {
    fun findByField1(field1: String): List<Entity480>
    fun findByField3GreaterThan(value: Int): List<Entity480>
}

@Service
@Transactional
class Service480(private val repo: Entity480Repository) {
    fun findAll(): List<Entity480> = repo.findAll()
    fun findByName(name: String): List<Entity480> = repo.findByField1(name)
    fun save(entity: Entity480): Entity480 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity480>): List<Entity480> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
