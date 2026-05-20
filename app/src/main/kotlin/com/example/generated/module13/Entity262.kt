package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_262")
data class Entity262(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity262Repository : org.springframework.data.jpa.repository.JpaRepository<Entity262, Long> {
    fun findByField1(field1: String): List<Entity262>
    fun findByField3GreaterThan(value: Int): List<Entity262>
}

@Service
@Transactional
class Service262(private val repo: Entity262Repository) {
    fun findAll(): List<Entity262> = repo.findAll()
    fun findByName(name: String): List<Entity262> = repo.findByField1(name)
    fun save(entity: Entity262): Entity262 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity262>): List<Entity262> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
