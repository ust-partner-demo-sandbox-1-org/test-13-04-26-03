package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_281")
data class Entity281(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity281Repository : org.springframework.data.jpa.repository.JpaRepository<Entity281, Long> {
    fun findByField1(field1: String): List<Entity281>
    fun findByField3GreaterThan(value: Int): List<Entity281>
}

@Service
@Transactional
class Service281(private val repo: Entity281Repository) {
    fun findAll(): List<Entity281> = repo.findAll()
    fun findByName(name: String): List<Entity281> = repo.findByField1(name)
    fun save(entity: Entity281): Entity281 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity281>): List<Entity281> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
