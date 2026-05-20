package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_153")
data class Entity153(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity153Repository : org.springframework.data.jpa.repository.JpaRepository<Entity153, Long> {
    fun findByField1(field1: String): List<Entity153>
    fun findByField3GreaterThan(value: Int): List<Entity153>
}

@Service
@Transactional
class Service153(private val repo: Entity153Repository) {
    fun findAll(): List<Entity153> = repo.findAll()
    fun findByName(name: String): List<Entity153> = repo.findByField1(name)
    fun save(entity: Entity153): Entity153 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity153>): List<Entity153> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
