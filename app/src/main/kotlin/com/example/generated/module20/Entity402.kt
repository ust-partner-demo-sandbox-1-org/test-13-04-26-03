package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_402")
data class Entity402(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity402Repository : org.springframework.data.jpa.repository.JpaRepository<Entity402, Long> {
    fun findByField1(field1: String): List<Entity402>
    fun findByField3GreaterThan(value: Int): List<Entity402>
}

@Service
@Transactional
class Service402(private val repo: Entity402Repository) {
    fun findAll(): List<Entity402> = repo.findAll()
    fun findByName(name: String): List<Entity402> = repo.findByField1(name)
    fun save(entity: Entity402): Entity402 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity402>): List<Entity402> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
