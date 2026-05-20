package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_129")
data class Entity129(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity129Repository : org.springframework.data.jpa.repository.JpaRepository<Entity129, Long> {
    fun findByField1(field1: String): List<Entity129>
    fun findByField3GreaterThan(value: Int): List<Entity129>
}

@Service
@Transactional
class Service129(private val repo: Entity129Repository) {
    fun findAll(): List<Entity129> = repo.findAll()
    fun findByName(name: String): List<Entity129> = repo.findByField1(name)
    fun save(entity: Entity129): Entity129 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity129>): List<Entity129> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
