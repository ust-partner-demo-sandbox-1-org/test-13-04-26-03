package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_45")
data class Entity45(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity45Repository : org.springframework.data.jpa.repository.JpaRepository<Entity45, Long> {
    fun findByField1(field1: String): List<Entity45>
    fun findByField3GreaterThan(value: Int): List<Entity45>
}

@Service
@Transactional
class Service45(private val repo: Entity45Repository) {
    fun findAll(): List<Entity45> = repo.findAll()
    fun findByName(name: String): List<Entity45> = repo.findByField1(name)
    fun save(entity: Entity45): Entity45 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity45>): List<Entity45> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
