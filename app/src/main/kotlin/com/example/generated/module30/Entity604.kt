package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_604")
data class Entity604(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity604Repository : org.springframework.data.jpa.repository.JpaRepository<Entity604, Long> {
    fun findByField1(field1: String): List<Entity604>
    fun findByField3GreaterThan(value: Int): List<Entity604>
}

@Service
@Transactional
class Service604(private val repo: Entity604Repository) {
    fun findAll(): List<Entity604> = repo.findAll()
    fun findByName(name: String): List<Entity604> = repo.findByField1(name)
    fun save(entity: Entity604): Entity604 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity604>): List<Entity604> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
