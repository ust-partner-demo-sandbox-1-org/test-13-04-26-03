package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_504")
data class Entity504(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity504Repository : org.springframework.data.jpa.repository.JpaRepository<Entity504, Long> {
    fun findByField1(field1: String): List<Entity504>
    fun findByField3GreaterThan(value: Int): List<Entity504>
}

@Service
@Transactional
class Service504(private val repo: Entity504Repository) {
    fun findAll(): List<Entity504> = repo.findAll()
    fun findByName(name: String): List<Entity504> = repo.findByField1(name)
    fun save(entity: Entity504): Entity504 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity504>): List<Entity504> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
