package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_522")
data class Entity522(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity522Repository : org.springframework.data.jpa.repository.JpaRepository<Entity522, Long> {
    fun findByField1(field1: String): List<Entity522>
    fun findByField3GreaterThan(value: Int): List<Entity522>
}

@Service
@Transactional
class Service522(private val repo: Entity522Repository) {
    fun findAll(): List<Entity522> = repo.findAll()
    fun findByName(name: String): List<Entity522> = repo.findByField1(name)
    fun save(entity: Entity522): Entity522 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity522>): List<Entity522> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
