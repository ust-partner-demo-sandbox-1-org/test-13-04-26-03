package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_911")
data class Entity911(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity911Repository : org.springframework.data.jpa.repository.JpaRepository<Entity911, Long> {
    fun findByField1(field1: String): List<Entity911>
    fun findByField3GreaterThan(value: Int): List<Entity911>
}

@Service
@Transactional
class Service911(private val repo: Entity911Repository) {
    fun findAll(): List<Entity911> = repo.findAll()
    fun findByName(name: String): List<Entity911> = repo.findByField1(name)
    fun save(entity: Entity911): Entity911 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity911>): List<Entity911> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
