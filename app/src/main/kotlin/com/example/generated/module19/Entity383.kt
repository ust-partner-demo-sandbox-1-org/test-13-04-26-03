package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_383")
data class Entity383(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity383Repository : org.springframework.data.jpa.repository.JpaRepository<Entity383, Long> {
    fun findByField1(field1: String): List<Entity383>
    fun findByField3GreaterThan(value: Int): List<Entity383>
}

@Service
@Transactional
class Service383(private val repo: Entity383Repository) {
    fun findAll(): List<Entity383> = repo.findAll()
    fun findByName(name: String): List<Entity383> = repo.findByField1(name)
    fun save(entity: Entity383): Entity383 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity383>): List<Entity383> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
