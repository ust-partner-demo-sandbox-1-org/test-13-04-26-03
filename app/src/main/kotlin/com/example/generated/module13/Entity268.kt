package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_268")
data class Entity268(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity268Repository : org.springframework.data.jpa.repository.JpaRepository<Entity268, Long> {
    fun findByField1(field1: String): List<Entity268>
    fun findByField3GreaterThan(value: Int): List<Entity268>
}

@Service
@Transactional
class Service268(private val repo: Entity268Repository) {
    fun findAll(): List<Entity268> = repo.findAll()
    fun findByName(name: String): List<Entity268> = repo.findByField1(name)
    fun save(entity: Entity268): Entity268 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity268>): List<Entity268> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
