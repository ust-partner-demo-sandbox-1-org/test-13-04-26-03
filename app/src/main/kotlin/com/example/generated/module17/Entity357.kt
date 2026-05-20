package com.example.generated.module17

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_357")
data class Entity357(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity357Repository : org.springframework.data.jpa.repository.JpaRepository<Entity357, Long> {
    fun findByField1(field1: String): List<Entity357>
    fun findByField3GreaterThan(value: Int): List<Entity357>
}

@Service
@Transactional
class Service357(private val repo: Entity357Repository) {
    fun findAll(): List<Entity357> = repo.findAll()
    fun findByName(name: String): List<Entity357> = repo.findByField1(name)
    fun save(entity: Entity357): Entity357 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity357>): List<Entity357> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
